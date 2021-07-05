package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 推广配置编辑对象 huomai_promote_config
 *
 * @author huomai
 * @date 2021-07-05
 */
@Data
@ApiModel("推广配置编辑对象")
public class HuomaiPromoteConfigEditBo {

  /** id */
  @ApiModelProperty("id")
  private Long id;

  /** 邀请人数 */
  @ApiModelProperty("邀请人数")
  @NotNull(message = "邀请人数不能为空")
  private Long inviteNum;

  /** 推广金额 */
  @ApiModelProperty("推广金额")
  @NotNull(message = "推广金额不能为空")
  private BigDecimal money;

  /** 推广平台比例 */
  @ApiModelProperty("推广平台比例")
  @NotNull(message = "推广平台比例不能为空")
  private BigDecimal platformRate;

  /** 邀请人比例 */
  @ApiModelProperty("邀请人比例")
  @NotNull(message = "邀请人比例不能为空")
  private BigDecimal inviteRate;

  /** 被助推人比例 */
  @ApiModelProperty("被助推人比例")
  @NotNull(message = "被助推人比例不能为空")
  private BigDecimal boosterRate;

  /** 热门人数限定 */
  @ApiModelProperty("热门人数限定")
  @NotNull(message = "热门人数限定不能为空")
  private Long maxNum;
}
