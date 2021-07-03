package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiVideoCommentAddBo;
import com.huomai.business.bo.HuomaiVideoCommentEditBo;
import com.huomai.business.bo.HuomaiVideoCommentQueryBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyQueryBo;
import com.huomai.business.domain.HuomaiVideoComment;
import com.huomai.business.mapper.HuomaiVideoCommentMapper;
import com.huomai.business.service.IHuomaiVideoCommentService;
import com.huomai.business.vo.HuomaiVideoCommentReplyVo;
import com.huomai.business.vo.HuomaiVideoCommentVo;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 评论Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiVideoCommentServiceImpl extends ServiceImpl<HuomaiVideoCommentMapper, HuomaiVideoComment> implements IHuomaiVideoCommentService {

	@Autowired
	private HuomaiVideoCommentMapper commentMapper;

	@Override
	public TableDataInfo<HuomaiVideoCommentReplyVo> queryById(HuomaiVideoCommentReplyQueryBo bo) {
		List<HuomaiVideoCommentReplyVo> list = commentMapper.queryListDetail(PageUtils.buildPage(),bo);
		return PageUtils.buildDataInfo(list);
	}

	@Override
	public TableDataInfo<HuomaiVideoCommentVo> queryPageList(HuomaiVideoCommentQueryBo bo) {
		List<HuomaiVideoCommentVo> list = commentMapper.queryList(PageUtils.buildPage(), bo);
		return PageUtils.buildDataInfo(list);
	}

	@Override
	public List<HuomaiVideoCommentVo> queryList(HuomaiVideoCommentQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiVideoCommentVo.class);
	}

	private LambdaQueryWrapper<HuomaiVideoComment> buildQueryWrapper(HuomaiVideoCommentQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiVideoComment> lqw = Wrappers.lambdaQuery();
//		lqw.eq(bo.getVideoId() != null, HuomaiVideoComment::getVideoId, bo.getVideoId());
//		lqw.eq(StrUtil.isNotBlank(bo.getContent()), HuomaiVideoComment::getContent, bo.getContent());
//		lqw.eq(bo.getUserId() != null, HuomaiVideoComment::getUserId, bo.getUserId());
//		lqw.eq(bo.getStarNum() != null, HuomaiVideoComment::getStarNum, bo.getStarNum());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiVideoCommentAddBo bo) {
		HuomaiVideoComment add = BeanUtil.toBean(bo, HuomaiVideoComment.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiVideoCommentEditBo bo) {
		HuomaiVideoComment update = BeanUtil.toBean(bo, HuomaiVideoComment.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiVideoComment entity) {
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
