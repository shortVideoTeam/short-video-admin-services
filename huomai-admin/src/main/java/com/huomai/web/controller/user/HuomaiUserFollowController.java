package com.huomai.web.controller.user;

import com.huomai.business.bo.HuomaiUserFollowQueryBo;
import com.huomai.business.service.IHuomaiUserFollowService;
import com.huomai.business.vo.HuomaiUserFollowDetailVo;
import com.huomai.business.vo.HuomaiUserFollowVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户关注Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(
    value = "用户关注控制器",
    tags = {"用户关注管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/follow")
public class HuomaiUserFollowController extends BaseController {

  private final IHuomaiUserFollowService iHuomaiUserFollowService;

  /** 查询用户关注列表 */
  @ApiOperation("查询用户关注列表")
  @PreAuthorize("@ss.hasPermi('business:follow:list')")
  @GetMapping("/list")
  public TableDataInfo<HuomaiUserFollowVo> list(@Validated HuomaiUserFollowQueryBo bo) {
    return iHuomaiUserFollowService.queryPageList(bo);
  }

  //	/**
  //	 * 导出用户关注列表
  //	 */
  //	@ApiOperation("导出用户关注列表")
  //	@PreAuthorize("@ss.hasPermi('business:follow:export')")
  //	@Log(title = "用户关注", businessType = BusinessType.EXPORT)
  //	@GetMapping("/export")
  //	public AjaxResult<HuomaiUserFollowVo> export(@Validated HuomaiUserFollowQueryBo bo) {
  //		List<HuomaiUserFollowVo> list = iHuomaiUserFollowService.queryList(bo);
  //		ExcelUtil<HuomaiUserFollowVo> util = new
  // ExcelUtil<HuomaiUserFollowVo>(HuomaiUserFollowVo.class);
  //		return util.exportExcel(list, "用户关注");
  //	}

  /** 获取用户关注详细信息 */
  @ApiOperation("获取用户关注详细信息")
  @PreAuthorize("@ss.hasPermi('business:follow:query')")
  @GetMapping("/detail")
  public TableDataInfo<HuomaiUserFollowDetailVo> getInfo(@Validated HuomaiUserFollowQueryBo bo) {
    return iHuomaiUserFollowService.queryById(bo);
  }

  //	/**
  //	 * 新增用户关注
  //	 */
  //	@ApiOperation("新增用户关注")
  //	@PreAuthorize("@ss.hasPermi('business:follow:add')")
  //	@Log(title = "用户关注", businessType = BusinessType.INSERT)
  //	@PostMapping()
  //	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserFollowAddBo bo) {
  //		return toAjax(iHuomaiUserFollowService.insertByAddBo(bo) ? 1 : 0);
  //	}
  //
  //	/**
  //	 * 修改用户关注
  //	 */
  //	@ApiOperation("修改用户关注")
  //	@PreAuthorize("@ss.hasPermi('business:follow:edit')")
  //	@Log(title = "用户关注", businessType = BusinessType.UPDATE)
  //	@PutMapping()
  //	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiUserFollowEditBo bo) {
  //		return toAjax(iHuomaiUserFollowService.updateByEditBo(bo) ? 1 : 0);
  //	}
  //
  //	/**
  //	 * 删除用户关注
  //	 */
  //	@ApiOperation("删除用户关注")
  //	@PreAuthorize("@ss.hasPermi('business:follow:remove')")
  //	@Log(title = "用户关注", businessType = BusinessType.DELETE)
  //	@DeleteMapping("/{userIds}")
  //	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
  //								   @PathVariable Long[] userIds) {
  //		return toAjax(iHuomaiUserFollowService.deleteWithValidByIds(Arrays.asList(userIds), true) ? 1
  // : 0);
  //	}
}
