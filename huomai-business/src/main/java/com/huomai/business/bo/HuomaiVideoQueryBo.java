package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 视频信息分页查询对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("视频信息分页查询对象")
public class HuomaiVideoQueryBo extends BaseEntity {

	/**
	 * 分页大小
	 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/**
	 * 当前页数
	 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/**
	 * 排序列
	 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/**
	 * 排序的方向desc或者asc
	 */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


	/**
	 * 用户Id
	 */
	@ApiModelProperty("用户Id")
	private Long userId;

	/**
	 * 用户uuid
	 */
	@ApiModelProperty("用户火脉号")
	private Long uuid;

	/**
	 * 视频标题
	 */
	@ApiModelProperty("视频标题")
	private String title;


	/**
	 * 状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )
	 */
	@ApiModelProperty("状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )")
	private String status;

	/**
	 * 关键词ID (按","逗号拼接)
	 */
	@ApiModelProperty("关键词ID (按逗号拼接)")
	private String keywordId;

}
