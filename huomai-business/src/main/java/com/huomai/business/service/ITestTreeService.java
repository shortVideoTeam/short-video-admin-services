package com.huomai.business.service;

import com.huomai.common.core.page.IServicePlus;
import com.huomai.business.bo.TestTreeAddBo;
import com.huomai.business.bo.TestTreeEditBo;
import com.huomai.business.bo.TestTreeQueryBo;
import com.huomai.business.domain.TestTree;
import com.huomai.business.vo.TestTreeVo;

import java.util.Collection;
import java.util.List;

/**
 * 测试树表Service接口
 *
 * @author huomai
 * @date 2021-05-30
 */
public interface ITestTreeService extends IServicePlus<TestTree> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	TestTreeVo queryById(Long id);

	/**
	 * 查询列表
	 */
	List<TestTreeVo> queryList(TestTreeQueryBo bo);

	/**
	 * 根据新增业务对象插入测试树表
	 *
	 * @param bo 测试树表新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TestTreeAddBo bo);

	/**
	 * 根据编辑业务对象修改测试树表
	 *
	 * @param bo 测试树表编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TestTreeEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
