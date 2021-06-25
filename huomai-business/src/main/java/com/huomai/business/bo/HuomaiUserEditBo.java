package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 用户信息编辑对象 huomai_user
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户信息编辑对象")
public class HuomaiUserEditBo {


	/**
	 * 用户Id
	 */
	@ApiModelProperty("用户Id")
	@NotBlank(message = "用户火脉号Id不能为空")
	private Long userId;

	/**
	 * 用户火脉号Id
	 */
	@ApiModelProperty("用户火脉号Id")
	private String uuid;

	/**
	 * 微信同一用户同一应用唯一标识
	 */
	@ApiModelProperty("微信同一用户同一应用唯一标识")
	private String openid;

	/**
	 * 微信同一用户不同应用唯一标识
	 */
	@ApiModelProperty("微信同一用户不同应用唯一标识")
	private String unionid;

	/**
	 * 用户头像
	 */
	@ApiModelProperty("用户头像")
	private String avatar;

	/**
	 * 用户昵称
	 */
	@ApiModelProperty("用户昵称")
	private String nickName;

	/**
	 * 用户性别 (0未知 1男 2女)
	 */
	@ApiModelProperty("用户性别 (0未知 1男 2女)")
	private String sex;

	/**
	 * 用户生日
	 */
	@ApiModelProperty("用户生日")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;

	/**
	 * 手机号
	 */
	@ApiModelProperty("手机号")
	private String phone;

	/**
	 * 星座
	 */
	@ApiModelProperty("星座")
	private String constellation;

	/**
	 * 省
	 */
	@ApiModelProperty("省")
	private Long province;

	/**
	 * 市
	 */
	@ApiModelProperty("市")
	private Long city;

	/**
	 * 区
	 */
	@ApiModelProperty("区")
	private Long area;

	/**
	 * 详细地址
	 */
	@ApiModelProperty("详细地址")
	private String address;

	/**
	 * 个人介绍
	 */
	@ApiModelProperty("个人介绍")
	private String desc;

	/**
	 * 更新者
	 */
	@ApiModelProperty("更新者")
	private String updateBy;

	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;

	/**
	 * 状态
	 */
	@ApiModelProperty("状态")
	private String status;
}
