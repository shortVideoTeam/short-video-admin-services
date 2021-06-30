package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiUserFollowQueryBo;
import com.huomai.business.domain.HuomaiUserFollow;
import com.huomai.business.vo.HuomaiUserFollowDetailVo;
import com.huomai.business.vo.HuomaiUserFollowVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户关注Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiUserFollowMapper extends BaseMapperPlus<HuomaiUserFollow> {

  /** 查询统计用户关注好友列表数 */
  List<HuomaiUserFollowVo> queryList(
      @Param("page") Page page, @Param("bo") HuomaiUserFollowQueryBo bo);

  /** 查看用户关注好友详情 */
  List<HuomaiUserFollowDetailVo> queryDetailList(
      @Param("page") Page page, @Param("bo") HuomaiUserFollowQueryBo bo);
}
