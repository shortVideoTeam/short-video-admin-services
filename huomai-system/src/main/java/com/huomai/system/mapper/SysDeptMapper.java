package com.huomai.system.mapper;

import com.huomai.common.core.domain.entity.SysDept;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门管理 数据层
 *
 * @author huomai
 */
public interface SysDeptMapper extends BaseMapperPlus<SysDept> {

	/**
	 * 查询部门管理数据
	 *
	 * @param dept 部门信息
	 * @return 部门信息集合
	 */
	public List<SysDept> selectDeptList(SysDept dept);

	/**
	 * 根据角色ID查询部门树信息
	 *
	 * @param roleId            角色ID
	 * @param deptCheckStrictly 部门树选择项是否关联显示
	 * @return 选中部门列表
	 */
	public List<Integer> selectDeptListByRoleId(@Param("roleId") Long roleId, @Param("deptCheckStrictly") boolean deptCheckStrictly);

	/**
	 * 修改子元素关系
	 *
	 * @param depts 子元素
	 * @return 结果
	 */
	public int updateDeptChildren(@Param("depts") List<SysDept> depts);

}
