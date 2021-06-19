package com.huomai.business.service;

import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.business.bo.ChkjTestAddBo;
import com.huomai.business.bo.ChkjTestEditBo;
import com.huomai.business.bo.ChkjTestQueryBo;
import com.huomai.business.domain.ChkjTest;
import com.huomai.business.vo.ChkjTestVo;

import java.util.Collection;
import java.util.List;

/**
 * 测试Service接口
 *
 * @author huomai
 * @date 2021-05-14
 */
public interface IChkjTestService extends IServicePlus<ChkjTest> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	ChkjTestVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<ChkjTestVo> queryPageList(ChkjTestQueryBo bo);

	/**
	 * 查询列表
	 */
	List<ChkjTestVo> queryList(ChkjTestQueryBo bo);

	/**
	 * 根据新增业务对象插入测试
	 *
	 * @param bo 测试新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(ChkjTestAddBo bo);

	/**
	 * 根据编辑业务对象修改测试
	 *
	 * @param bo 测试编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(ChkjTestEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
