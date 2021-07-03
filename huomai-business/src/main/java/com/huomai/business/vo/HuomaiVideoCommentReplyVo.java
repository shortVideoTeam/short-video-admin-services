package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 回复视图对象 huomai_video_comment_reply
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("回复视图对象")
public class HuomaiVideoCommentReplyVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty("主键")
	private Long id;

	/**
	 * 回复类型 (1 : 评论的回复 2 : 回复的回复)
	 */
	@Excel(name = "回复类型 (1 : 评论的回复 2 : 回复的回复)")
	@ApiModelProperty("回复类型 (1 : 评论的回复 2 : 回复的回复)")
	private String replyType;

	/**
	 * 评论Id
	 */
	@Excel(name = "评论Id")
	@ApiModelProperty("评论Id")
	private Long commentId;

	/**
	 * 回复目标ID
	 */
	@Excel(name = "回复目标ID")
	@ApiModelProperty("回复目标ID")
	private Long replyId;

	/**
	 * 回复内容
	 */
	@Excel(name = "回复内容")
	@ApiModelProperty("回复内容")
	private String content;

	/**
	 * 回复用户ID
	 */
	@Excel(name = "回复用户ID")
	@ApiModelProperty("回复用户ID")
	private Long replyUserId;

	/**
	 * 目标用户id
	 */
	@Excel(name = "目标用户id")
	@ApiModelProperty("目标用户id")
	private Long toUserId;

	/**
	 * 点赞数
	 */
	@Excel(name = "点赞数")
	@ApiModelProperty("点赞数")
	private Long star;


	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

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
