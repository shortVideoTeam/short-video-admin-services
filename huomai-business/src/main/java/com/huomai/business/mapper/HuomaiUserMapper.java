package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiUserQueryBo;
import com.huomai.business.domain.HuomaiUser;
import com.huomai.business.vo.HuomaiUserVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiUserMapper extends BaseMapperPlus<HuomaiUser> {

	/**
	 * 查询用户列表
	 * @param page
	 * @param bo
	 * @return
	 */
	List<HuomaiUserVo> queryList(@Param("page") Page page, @Param("bo") HuomaiUserQueryBo bo);
}
