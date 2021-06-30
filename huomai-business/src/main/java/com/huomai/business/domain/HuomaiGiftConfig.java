package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 红包金额配置对象 huomai_gift_config
 *
 * @author huomai
 * @date 2021-06-30
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_gift_config")
public class HuomaiGiftConfig implements Serializable {

  private static final long serialVersionUID = 1L;

  /** ID */
  @TableId(value = "id")
  private Long id;

  /** 总金额 */
  private BigDecimal totalAmount;

  /** 单笔领取金额 */
  private BigDecimal singleAmount;
}
