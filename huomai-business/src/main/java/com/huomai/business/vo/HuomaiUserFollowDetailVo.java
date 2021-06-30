package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("用户关注视图对象")
public class HuomaiUserFollowDetailVo {

  private static final long serialVersionUID = 1L;

  /** 用户id */
  @ApiModelProperty("用户id")
  private Long userId;

  @ApiModelProperty("用户火脉号")
  private Long uuId;

  @ApiModelProperty("用户openId")
  private String openId;

  @ApiModelProperty("用户头像")
  private String avatar;

  @ApiModelProperty("用户昵称")
  private String nickName;

  @ApiModelProperty("用户手机号")
  private String phone;

  @ApiModelProperty("来源")
  private int source;

  @ApiModelProperty("关注时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  @ApiModelProperty("备注")
  private String remark;
}
