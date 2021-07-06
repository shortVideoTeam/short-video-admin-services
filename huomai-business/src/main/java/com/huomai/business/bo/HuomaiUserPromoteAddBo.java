package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 推广记录添加对象 huomai_user_promote
 *
 * @author huomai
 * @date 2021-07-06
 */
@Data
@ApiModel("推广记录添加对象")
public class HuomaiUserPromoteAddBo {

  /** 用户ID */
  @ApiModelProperty("用户ID")
  @NotNull(message = "用户ID不能为空")
  private Long userId;

  /** 视频ID */
  @ApiModelProperty("视频ID")
  @NotNull(message = "视频ID不能为空")
  private Long videoId;

  /** 推广时间 */
  @ApiModelProperty("推广时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  /** 推广状态( 1: 已报名 2: 已参与 3:已失效 ) */
  @ApiModelProperty("推广状态( 1: 已报名 2: 已参与 3:已失效 )")
  private String status;

  /** 热门次数 */
  @ApiModelProperty("热门次数")
  private Long hotNum;

  /** 推广收益 */
  @ApiModelProperty("推广收益")
  private BigDecimal profit;

  /** 发出推广值 */
  @ApiModelProperty("发出推广值")
  private BigDecimal sendVal;

  /** 收到推广值 */
  @ApiModelProperty("收到推广值")
  private BigDecimal receivedVal;
}
