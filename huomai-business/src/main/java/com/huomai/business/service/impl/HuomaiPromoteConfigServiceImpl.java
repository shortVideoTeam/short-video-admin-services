package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiPromoteConfigAddBo;
import com.huomai.business.bo.HuomaiPromoteConfigEditBo;
import com.huomai.business.bo.HuomaiPromoteConfigQueryBo;
import com.huomai.business.domain.HuomaiPromoteConfig;
import com.huomai.business.mapper.HuomaiPromoteConfigMapper;
import com.huomai.business.service.IHuomaiPromoteConfigService;
import com.huomai.business.vo.HuomaiPromoteConfigVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 推广配置Service业务层处理
 *
 * @author huomai
 * @date 2021-07-05
 */
@Service
public class HuomaiPromoteConfigServiceImpl
    extends ServiceImpl<HuomaiPromoteConfigMapper, HuomaiPromoteConfig>
    implements IHuomaiPromoteConfigService {

  @Override
  public HuomaiPromoteConfigVo queryById(Long id) {
    return getVoById(id, HuomaiPromoteConfigVo.class);
  }

  @Override
  public TableDataInfo<HuomaiPromoteConfigVo> queryPageList(HuomaiPromoteConfigQueryBo bo) {
    PagePlus<HuomaiPromoteConfig, HuomaiPromoteConfigVo> result =
        pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiPromoteConfigVo.class);
    return PageUtils.buildDataInfo(result);
  }

  @Override
  public List<HuomaiPromoteConfigVo> queryList(HuomaiPromoteConfigQueryBo bo) {
    return listVo(buildQueryWrapper(bo), HuomaiPromoteConfigVo.class);
  }

  private LambdaQueryWrapper<HuomaiPromoteConfig> buildQueryWrapper(HuomaiPromoteConfigQueryBo bo) {
    Map<String, Object> params = bo.getParams();
    LambdaQueryWrapper<HuomaiPromoteConfig> lqw = Wrappers.lambdaQuery();
    lqw.eq(bo.getInviteNum() != null, HuomaiPromoteConfig::getInviteNum, bo.getInviteNum());
    lqw.eq(bo.getMoney() != null, HuomaiPromoteConfig::getMoney, bo.getMoney());
    lqw.eq(
        bo.getPlatformRate() != null, HuomaiPromoteConfig::getPlatformRate, bo.getPlatformRate());
    lqw.eq(bo.getInviteRate() != null, HuomaiPromoteConfig::getInviteRate, bo.getInviteRate());
    lqw.eq(bo.getBoosterRate() != null, HuomaiPromoteConfig::getBoosterRate, bo.getBoosterRate());
    lqw.eq(bo.getMaxNum() != null, HuomaiPromoteConfig::getMaxNum, bo.getMaxNum());
    return lqw;
  }

  @Override
  public Boolean insertByAddBo(HuomaiPromoteConfigAddBo bo) {
    HuomaiPromoteConfig add = BeanUtil.toBean(bo, HuomaiPromoteConfig.class);
    validEntityBeforeSave(add);
    return save(add);
  }

  @Override
  public Boolean updateByEditBo(HuomaiPromoteConfigEditBo bo) {
    HuomaiPromoteConfig update = BeanUtil.toBean(bo, HuomaiPromoteConfig.class);
    validEntityBeforeSave(update);
    return updateById(update);
  }

  /**
   * 保存前的数据校验
   *
   * @param entity 实体类数据
   */
  private void validEntityBeforeSave(HuomaiPromoteConfig entity) {
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
