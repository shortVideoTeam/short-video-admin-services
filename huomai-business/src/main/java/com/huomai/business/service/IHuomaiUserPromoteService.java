package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserPromoteAddBo;
import com.huomai.business.bo.HuomaiUserPromoteEditBo;
import com.huomai.business.bo.HuomaiUserPromoteQueryBo;
import com.huomai.business.domain.HuomaiUserPromote;
import com.huomai.business.vo.HuomaiUserPromoteVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 推广记录Service接口
 *
 * @author huomai
 * @date 2021-07-06
 */
public interface IHuomaiUserPromoteService extends IServicePlus<HuomaiUserPromote> {
  /**
   * 查询单个
   *
   * @return
   */
  HuomaiUserPromoteVo queryById(Long id);

  /** 查询列表 */
  TableDataInfo<HuomaiUserPromoteVo> queryPageList(HuomaiUserPromoteQueryBo bo);

  /** 查询列表 */
  List<HuomaiUserPromoteVo> queryList(HuomaiUserPromoteQueryBo bo);

  /**
   * 根据新增业务对象插入推广记录
   *
   * @param bo 推广记录新增业务对象
   * @return
   */
  Boolean insertByAddBo(HuomaiUserPromoteAddBo bo);

  /**
   * 根据编辑业务对象修改推广记录
   *
   * @param bo 推广记录编辑业务对象
   * @return
   */
  Boolean updateByEditBo(HuomaiUserPromoteEditBo bo);

  /**
   * 校验并删除数据
   *
   * @param ids 主键集合
   * @param isValid 是否校验,true-删除前校验,false-不校验
   * @return
   */
  Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
