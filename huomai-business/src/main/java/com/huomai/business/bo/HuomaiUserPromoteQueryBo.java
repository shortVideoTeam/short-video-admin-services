package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 推广记录分页查询对象 huomai_user_promote
 *
 * @author huomai
 * @date 2021-07-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("推广记录分页查询对象")
public class HuomaiUserPromoteQueryBo extends BaseEntity {

  /** 分页大小 */
  @ApiModelProperty("分页大小")
  private Integer pageSize;
  /** 当前页数 */
  @ApiModelProperty("当前页数")
  private Integer pageNum;
  /** 排序列 */
  @ApiModelProperty("排序列")
  private String orderByColumn;
  /** 排序的方向desc或者asc */
  @ApiModelProperty(value = "排序的方向", example = "asc,desc")
  private String isAsc;

  /** 推广状态( 1: 已报名 2: 已参与 3:已失效 ) */
  @ApiModelProperty("推广状态( 1: 已报名 2: 已参与 3:已失效 )")
  private String status;

  @ApiModelProperty("用户火脉号")
  private Long uuid;

  @ApiModelProperty("视频标题")
  private String title;
}
