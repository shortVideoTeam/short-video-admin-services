package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 评论视图对象 huomai_video_comment
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("评论视图对象")
public class HuomaiVideoCommentVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 评论ID
	 */
	@ApiModelProperty("评论ID")
	private Long commentId;

	/**
	 * 视频ID
	 */
	@Excel(name = "视频ID")
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 评论内容
	 */
	@Excel(name = "评论内容")
	@ApiModelProperty("评论内容")
	private String content;

	/**
	 * 评论用户Id
	 */
	@Excel(name = "评论用户Id")
	@ApiModelProperty("评论用户Id")
	private Long userId;

	/**
	 * 评论点赞数
	 */
	@Excel(name = "评论点赞数")
	@ApiModelProperty("评论点赞数")
	private Long starNum;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

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
	 * 用户火脉号
	 */
	@Excel(name = "用户火脉号")
	@ApiModelProperty("用户火脉号")
	private Long uuid;

	/**
	 * 用户昵称
	 */
	@Excel(name = "用户昵称")
	@ApiModelProperty("用户昵称")
	private String nickName;

	/**
	 * 用户头像
	 */
	@Excel(name = "用户头像")
	@ApiModelProperty("用户头像")
	private String avatar;

	/**
	 * 用户手机号
	 */
	@Excel(name = "用户手机号")
	@ApiModelProperty("用户手机号")
	private String phone;


}
