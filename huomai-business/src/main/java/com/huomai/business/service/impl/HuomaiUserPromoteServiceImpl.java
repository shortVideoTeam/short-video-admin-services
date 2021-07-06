package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserPromoteAddBo;
import com.huomai.business.bo.HuomaiUserPromoteEditBo;
import com.huomai.business.bo.HuomaiUserPromoteQueryBo;
import com.huomai.business.domain.HuomaiUserPromote;
import com.huomai.business.mapper.HuomaiUserPromoteMapper;
import com.huomai.business.service.IHuomaiUserPromoteService;
import com.huomai.business.vo.HuomaiUserPromoteVo;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 推广记录Service业务层处理
 *
 * @author huomai
 * @date 2021-07-06
 */
@Service
public class HuomaiUserPromoteServiceImpl
    extends ServiceImpl<HuomaiUserPromoteMapper, HuomaiUserPromote>
    implements IHuomaiUserPromoteService {

  @Autowired private HuomaiUserPromoteMapper promoteMapper;

  @Override
  public HuomaiUserPromoteVo queryById(Long id) {
    return getVoById(id, HuomaiUserPromoteVo.class);
  }

  @Override
  public TableDataInfo<HuomaiUserPromoteVo> queryPageList(HuomaiUserPromoteQueryBo bo) {
    List<HuomaiUserPromoteVo> list = promoteMapper.queryList(PageUtils.buildPage(), bo);
    return PageUtils.buildDataInfo(list);
  }

  @Override
  public List<HuomaiUserPromoteVo> queryList(HuomaiUserPromoteQueryBo bo) {
    return listVo(buildQueryWrapper(bo), HuomaiUserPromoteVo.class);
  }

  private LambdaQueryWrapper<HuomaiUserPromote> buildQueryWrapper(HuomaiUserPromoteQueryBo bo) {
    Map<String, Object> params = bo.getParams();
    LambdaQueryWrapper<HuomaiUserPromote> lqw = Wrappers.lambdaQuery();
    //    lqw.eq(bo.getUserId() != null, HuomaiUserPromote::getUserId, bo.getUserId());
    //    lqw.eq(bo.getVideoId() != null, HuomaiUserPromote::getVideoId, bo.getVideoId());
    //    lqw.eq(StrUtil.isNotBlank(bo.getStatus()), HuomaiUserPromote::getStatus, bo.getStatus());
    //    lqw.eq(bo.getHotNum() != null, HuomaiUserPromote::getHotNum, bo.getHotNum());
    //    lqw.eq(bo.getProfit() != null, HuomaiUserPromote::getProfit, bo.getProfit());
    //    lqw.eq(bo.getSendVal() != null, HuomaiUserPromote::getSendVal, bo.getSendVal());
    //    lqw.eq(bo.getReceivedVal() != null, HuomaiUserPromote::getReceivedVal,
    // bo.getReceivedVal());
    return lqw;
  }

  @Override
  public Boolean insertByAddBo(HuomaiUserPromoteAddBo bo) {
    HuomaiUserPromote add = BeanUtil.toBean(bo, HuomaiUserPromote.class);
    validEntityBeforeSave(add);
    return save(add);
  }

  @Override
  public Boolean updateByEditBo(HuomaiUserPromoteEditBo bo) {
    HuomaiUserPromote update = BeanUtil.toBean(bo, HuomaiUserPromote.class);
    validEntityBeforeSave(update);
    return updateById(update);
  }

  /**
   * 保存前的数据校验
   *
   * @param entity 实体类数据
   */
  private void validEntityBeforeSave(HuomaiUserPromote entity) {
    // TODO 做一些数据校验,如唯一约束
  }

  @Override
  public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
    if (isValid) {
      // TODO 做一些业务上的校验,判断是否需要校验
    }
    return removeByIds(ids);
  }
}
