package com.huomai.business.service;

import com.huomai.business.bo.HuomaiPromoteConfigAddBo;
import com.huomai.business.bo.HuomaiPromoteConfigEditBo;
import com.huomai.business.bo.HuomaiPromoteConfigQueryBo;
import com.huomai.business.domain.HuomaiPromoteConfig;
import com.huomai.business.vo.HuomaiPromoteConfigVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 推广配置Service接口
 *
 * @author huomai
 * @date 2021-07-05
 */
public interface IHuomaiPromoteConfigService extends IServicePlus<HuomaiPromoteConfig> {
  /**
   * 查询单个
   *
   * @return
   */
  HuomaiPromoteConfigVo queryById(Long id);

  /** 查询列表 */
  TableDataInfo<HuomaiPromoteConfigVo> queryPageList(HuomaiPromoteConfigQueryBo bo);

  /** 查询列表 */
  List<HuomaiPromoteConfigVo> queryList(HuomaiPromoteConfigQueryBo bo);

  /**
   * 根据新增业务对象插入推广配置
   *
   * @param bo 推广配置新增业务对象
   * @return
   */
  Boolean insertByAddBo(HuomaiPromoteConfigAddBo bo);

  /**
   * 根据编辑业务对象修改推广配置
   *
   * @param bo 推广配置编辑业务对象
   * @return
   */
  Boolean updateByEditBo(HuomaiPromoteConfigEditBo bo);

  /**
   * 校验并删除数据
   *
   * @param ids 主键集合
   * @param isValid 是否校验,true-删除前校验,false-不校验
   * @return
   */
  Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
