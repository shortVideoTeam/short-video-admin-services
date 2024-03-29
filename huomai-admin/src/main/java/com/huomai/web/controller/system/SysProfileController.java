package com.huomai.web.controller.system;

import cn.hutool.core.util.StrUtil;
import com.huomai.common.annotation.Log;
import com.huomai.common.config.HuoMaiConfig;
import com.huomai.common.constant.UserConstants;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.domain.entity.SysUser;
import com.huomai.common.core.domain.model.LoginUser;
import com.huomai.common.enums.BusinessType;
import com.huomai.common.utils.SecurityUtils;
import com.huomai.common.utils.ServletUtils;
import com.huomai.common.utils.file.FileUploadUtils;
import com.huomai.framework.web.service.TokenService;
import com.huomai.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 个人信息 业务处理
 *
 * @author huomai
 */
@RestController
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController {
	@Autowired
	private ISysUserService userService;

	@Autowired
	private TokenService tokenService;

	/**
	 * 个人信息
	 */
	@GetMapping
	public AjaxResult profile() {
		LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
		SysUser user = loginUser.getUser();
		Map<String, Object> ajax = new HashMap<>();
		ajax.put("user", user);
		ajax.put("roleGroup", userService.selectUserRoleGroup(loginUser.getUsername()));
		ajax.put("postGroup", userService.selectUserPostGroup(loginUser.getUsername()));
		return AjaxResult.success(ajax);
	}

	/**
	 * 修改用户
	 */
	@Log(title = "个人信息", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult updateProfile(@RequestBody SysUser user) {
		if (StrUtil.isNotEmpty(user.getPhonenumber())
			&& UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
			return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
		}
		if (StrUtil.isNotEmpty(user.getEmail())
			&& UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
			return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
		}
		if (userService.updateUserProfile(user) > 0) {
			LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
			// 更新缓存用户信息
			loginUser.getUser().setNickName(user.getNickName());
			loginUser.getUser().setPhonenumber(user.getPhonenumber());
			loginUser.getUser().setEmail(user.getEmail());
			loginUser.getUser().setSex(user.getSex());
			tokenService.setLoginUser(loginUser);
			return AjaxResult.success();
		}
		return AjaxResult.error("修改个人信息异常，请联系管理员");
	}

	/**
	 * 重置密码
	 */
	@Log(title = "个人信息", businessType = BusinessType.UPDATE)
	@PutMapping("/updatePwd")
	public AjaxResult updatePwd(String oldPassword, String newPassword) {
		LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
		String userName = loginUser.getUsername();
		String password = loginUser.getPassword();
		if (!SecurityUtils.matchesPassword(oldPassword, password)) {
			return AjaxResult.error("修改密码失败，旧密码错误");
		}
		if (SecurityUtils.matchesPassword(newPassword, password)) {
			return AjaxResult.error("新密码不能与旧密码相同");
		}
		if (userService.resetUserPwd(userName, SecurityUtils.encryptPassword(newPassword)) > 0) {
			// 更新缓存用户密码
			loginUser.getUser().setPassword(SecurityUtils.encryptPassword(newPassword));
			tokenService.setLoginUser(loginUser);
			return AjaxResult.success();
		}
		return AjaxResult.error("修改密码异常，请联系管理员");
	}

	/**
	 * 头像上传
	 */
	@Log(title = "用户头像", businessType = BusinessType.UPDATE)
	@PostMapping("/avatar")
	public AjaxResult avatar(@RequestParam("avatarfile") MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
			String avatar = FileUploadUtils.upload(HuoMaiConfig.getAvatarPath(), file);
			if (userService.updateUserAvatar(loginUser.getUsername(), avatar)) {
				Map<String, Object> ajax = new HashMap<>();
				ajax.put("imgUrl", avatar);
				// 更新缓存用户头像
				loginUser.getUser().setAvatar(avatar);
				tokenService.setLoginUser(loginUser);
				return AjaxResult.success(ajax);
			}
		}
		return AjaxResult.error("上传图片异常，请联系管理员");
	}
}
