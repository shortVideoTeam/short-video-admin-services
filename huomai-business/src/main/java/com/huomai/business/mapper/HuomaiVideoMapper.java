package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiVideoQueryBo;
import com.huomai.business.domain.HuomaiVideo;
import com.huomai.business.vo.HuomaiVideoVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视频信息Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiVideoMapper extends BaseMapperPlus<HuomaiVideo> {

	/**
	 * 查询视频列表
	 * @param page
	 * @param bo
	 * @return
	 */
	List<HuomaiVideoVo> queryList(@Param("page") Page page, @Param("bo") HuomaiVideoQueryBo bo);
}
