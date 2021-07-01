package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 视频信息视图对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("视频信息视图对象")
public class HuomaiVideoVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 用户Id
	 */
	@Excel(name = "用户Id")
	@ApiModelProperty("用户Id")
	private Long userId;

	/**
	 * 视频标题
	 */
	@Excel(name = "视频标题")
	@ApiModelProperty("视频标题")
	private String title;

	/**
	 * 视频地址
	 */
	@Excel(name = "视频地址")
	@ApiModelProperty("视频地址")
	private String videoUrl;

	/**
	 * 视频时长
	 */
	@Excel(name = "视频时长")
	@ApiModelProperty("视频时长")
	private Long duration;

	/**
	 * 关联话题 (按","逗号拼接)
	 */
	@Excel(name = "关联话题 (按逗号拼接)")
	@ApiModelProperty("关联话题 (按逗号拼接)")
	private String topic;

	/**
	 * 关联好友 (按","逗号拼接)
	 */
	@Excel(name = "关联好友 (按逗号拼接)")
	@ApiModelProperty("关联好友 (按逗号拼接)")
	private String buddy;

	/**
	 * 是否可见 (1 公开 0 私密)
	 */
	@Excel(name = "是否可见 (1 公开 0 私密)")
	@ApiModelProperty("是否可见 (1 公开 0 私密)")
	private String visible;

	/**
	 * 状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )
	 */
	@Excel(name = "状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )")
	@ApiModelProperty("状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )")
	private String status;

	/**
	 * 点赞量
	 */
	@Excel(name = "点赞量")
	@ApiModelProperty("点赞量")
	private Long starNum;

	/**
	 * 评论量
	 */
	@Excel(name = "评论量")
	@ApiModelProperty("评论量")
	private Long commentNum;

	/**
	 * 播放量
	 */
	@Excel(name = "播放量")
	@ApiModelProperty("播放量")
	private Long viewNum;

	/**
	 * 关键词
	 */
	@Excel(name = "关键词")
	@ApiModelProperty("关键词")
	private String keyword;

	/**
	 * 备注
	 */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String remark;

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
}
