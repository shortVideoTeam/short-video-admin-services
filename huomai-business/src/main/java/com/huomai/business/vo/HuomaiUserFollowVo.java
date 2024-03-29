package com.huomai.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户关注视图对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户关注视图对象")
public class HuomaiUserFollowVo {

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

  @ApiModelProperty("用户关注总数")
  private String followNumber;
}
