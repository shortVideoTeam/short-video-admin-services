package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.TestTreeAddBo;
import com.huomai.business.bo.TestTreeEditBo;
import com.huomai.business.bo.TestTreeQueryBo;
import com.huomai.business.domain.TestTree;
import com.huomai.business.mapper.TestTreeMapper;
import com.huomai.business.service.ITestTreeService;
import com.huomai.business.vo.TestTreeVo;
import com.huomai.common.annotation.DataScope;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 测试树表Service业务层处理
 *
 * @author huomai
 * @date 2021-05-30
 */
@Service
public class TestTreeServiceImpl extends ServiceImpl<TestTreeMapper, TestTree> implements ITestTreeService {

	@Override
	public TestTreeVo queryById(Long id) {
		return getVoById(id, TestTreeVo.class);
	}

	@DataScope(isUser = true)
	@Override
	public List<TestTreeVo> queryList(TestTreeQueryBo bo) {
		return listVo(buildQueryWrapper(bo), TestTreeVo.class);
	}

	private LambdaQueryWrapper<TestTree> buildQueryWrapper(TestTreeQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		Object dataScope = params.get("dataScope");
		LambdaQueryWrapper<TestTree> lqw = Wrappers.lambdaQuery();
		lqw.like(StrUtil.isNotBlank(bo.getTreeName()), TestTree::getTreeName, bo.getTreeName());
		lqw.between(params.get("beginCreateTime") != null && params.get("endCreateTime") != null,
			TestTree::getCreateTime, params.get("beginCreateTime"), params.get("endCreateTime"));
		lqw.apply(dataScope != null && StrUtil.isNotBlank(dataScope.toString()),
			dataScope != null ? dataScope.toString() : null);
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(TestTreeAddBo bo) {
		TestTree add = BeanUtil.toBean(bo, TestTree.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(TestTreeEditBo bo) {
		TestTree update = BeanUtil.toBean(bo, TestTree.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(TestTree entity) {
		//TODO 做一些数据校验,如唯一约束
	}

	@Override
	public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
		if (isValid) {
			//TODO 做一些业务上的校验,判断是否需要校验
		}
		return removeByIds(ids);
	}
}
