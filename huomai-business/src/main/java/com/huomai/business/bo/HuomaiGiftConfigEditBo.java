package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 红包金额配置编辑对象 huomai_gift_config
 *
 * @author huomai
 * @date 2021-06-30
 */
@Data
@ApiModel("红包金额配置编辑对象")
public class HuomaiGiftConfigEditBo {

  /** ID */
  @ApiModelProperty("ID")
  private Long id;

  /** 总金额 */
  @ApiModelProperty("总金额")
  private BigDecimal totalAmount;

  /** 单笔领取金额 */
  @ApiModelProperty("单笔领取金额")
  private BigDecimal singleAmount;
}
