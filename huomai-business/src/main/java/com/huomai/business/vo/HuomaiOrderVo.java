package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 订单记录视图对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("订单记录视图对象")
public class HuomaiOrderVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 订单类型
	 */
	@Excel(name = "订单类型")
	@ApiModelProperty("订单类型")
	private String orderType;


	/**
	 * 订单号
	 */
	@Excel(name = "订单号")
	@ApiModelProperty("订单号")
	private String orderNo;

	/**
	 * 用户ID
	 */
	@Excel(name = "用户ID")
	@ApiModelProperty("用户ID")
	private Long userId;

	/**
	 * 推广时长
	 */
	@Excel(name = "推广时长")
	@ApiModelProperty("推广时长")
	private Long time;

	/**
	 * 推荐页面，1-热门页
	 */
	@Excel(name = "推荐页面，1-热门页")
	@ApiModelProperty("推荐页面，1-热门页")
	private String page;

	/**
	 * 金额
	 */
	@Excel(name = "金额")
	@ApiModelProperty("金额")
	private BigDecimal amount;

	/**
	 * 支付时间
	 */
	@Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("支付时间")
	private Date payTime;

	/**
	 * 状态，1-待付款 2-已付款
	 */
	@Excel(name = "状态，1-待付款 2-已付款")
	@ApiModelProperty("状态，1-待付款 2-已付款")
	private String status;

	/**
	 * 支付方式 1-微信 2-余额
	 */
	@Excel(name = "支付方式 1-微信 2-余额")
	@ApiModelProperty("支付方式 1-微信 2-余额")
	private String payWay;


	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 用户火脉号Id
	 */
	@Excel(name = "用户火脉号Id")
	@ApiModelProperty("用户火脉号Id")
	private String uuid;

	/**
	 * 微信同一用户同一应用唯一标识
	 */
	@Excel(name = "微信同一用户同一应用唯一标识")
	@ApiModelProperty("微信同一用户同一应用唯一标识")
	private String openid;

	/**
	 * 用户头像
	 */
	@Excel(name = "用户头像")
	@ApiModelProperty("用户头像")
	private String avatar;

	/**
	 * 用户昵称
	 */
	@Excel(name = "用户昵称")
	@ApiModelProperty("用户昵称")
	private String nickName;

	/**
	 * 手机号
	 */
	@Excel(name = "手机号")
	@ApiModelProperty("手机号")
	private String phone;

	/**
	 * 备注
	 */
	@Excel(name="备注")
	@ApiModelProperty("备注")
	private String remark;

	/**
	 * 审核状态
	 */
	@Excel(name = "审核状态")
	@ApiModelProperty("审核状态")
	private String auditStatus;

	/**
	 * 微信流水号
	 */
	@Excel(name = "微信流水号")
	@ApiModelProperty("微信流水号")
	private String wxOrderNo;

	/**
	 * 审核时间
	 */
	@ApiModelProperty("审核时间")
	@Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date auditTime;
}
