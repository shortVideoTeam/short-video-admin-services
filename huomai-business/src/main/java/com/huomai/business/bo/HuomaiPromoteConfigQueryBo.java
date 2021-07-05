package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 推广配置分页查询对象 huomai_promote_config
 *
 * @author huomai
 * @date 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("推广配置分页查询对象")
public class HuomaiPromoteConfigQueryBo extends BaseEntity {

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

  /** 邀请人数 */
  @ApiModelProperty("邀请人数")
  private Long inviteNum;
  /** 推广金额 */
  @ApiModelProperty("推广金额")
  private BigDecimal money;
  /** 推广平台比例 */
  @ApiModelProperty("推广平台比例")
  private BigDecimal platformRate;
  /** 邀请人比例 */
  @ApiModelProperty("邀请人比例")
  private BigDecimal inviteRate;
  /** 被助推人比例 */
  @ApiModelProperty("被助推人比例")
  private BigDecimal boosterRate;
  /** 热门人数限定 */
  @ApiModelProperty("热门人数限定")
  private Long maxNum;
}
