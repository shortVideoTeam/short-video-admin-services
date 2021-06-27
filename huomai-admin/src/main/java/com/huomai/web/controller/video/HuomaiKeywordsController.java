package com.huomai.web.controller.video;

import com.huomai.business.bo.HuomaiKeywordsAddBo;
import com.huomai.business.bo.HuomaiKeywordsEditBo;
import com.huomai.business.bo.HuomaiKeywordsQueryBo;
import com.huomai.business.service.IHuomaiKeywordsService;
import com.huomai.business.vo.HuomaiKeywordsVo;
import com.huomai.common.annotation.Log;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * 关键词Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "关键词控制器", tags = {"关键词管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/keywords")
public class HuomaiKeywordsController extends BaseController {

	private final IHuomaiKeywordsService iHuomaiKeywordsService;

	/**
	 * 查询关键词列表
	 */
	@ApiOperation("查询关键词列表")
	@PreAuthorize("@ss.hasPermi('business:keywords:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiKeywordsVo> list(@Validated HuomaiKeywordsQueryBo bo) {
		return iHuomaiKeywordsService.queryPageList(bo);
	}

//	/**
//	 * 导出关键词列表
//	 */
//	@ApiOperation("导出关键词列表")
//	@PreAuthorize("@ss.hasPermi('business:keywords:export')")
//	@Log(title = "关键词", businessType = BusinessType.EXPORT)
//	@GetMapping("/export")
//	public AjaxResult<HuomaiKeywordsVo> export(@Validated HuomaiKeywordsQueryBo bo) {
//		List<HuomaiKeywordsVo> list = iHuomaiKeywordsService.queryList(bo);
//		ExcelUtil<HuomaiKeywordsVo> util = new ExcelUtil<HuomaiKeywordsVo>(HuomaiKeywordsVo.class);
//		return util.exportExcel(list, "关键词");
//	}

	/**
	 * 获取关键词详细信息
	 */
	@ApiOperation("获取关键词详细信息")
	@PreAuthorize("@ss.hasPermi('business:keywords:query')")
	@GetMapping("/{keywordId}")
	public AjaxResult<HuomaiKeywordsVo> getInfo(@NotNull(message = "主键不能为空")
												@PathVariable("keywordId") Long keywordId) {
		return AjaxResult.success(iHuomaiKeywordsService.queryById(keywordId));
	}

	/**
	 * 新增关键词
	 */
	@ApiOperation("新增关键词")
	@PreAuthorize("@ss.hasPermi('business:keywords:add')")
	@Log(title = "关键词", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiKeywordsAddBo bo) {
		return toAjax(iHuomaiKeywordsService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改关键词
	 */
	@ApiOperation("修改关键词")
	@PreAuthorize("@ss.hasPermi('business:keywords:edit')")
	@Log(title = "关键词", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiKeywordsEditBo bo) {
		return toAjax(iHuomaiKeywordsService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除关键词
	 */
	@ApiOperation("删除关键词")
	@PreAuthorize("@ss.hasPermi('business:keywords:remove')")
	@Log(title = "关键词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{keywordIds}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] keywordIds) {
		return toAjax(iHuomaiKeywordsService.deleteWithValidByIds(Arrays.asList(keywordIds), true) ? 1 : 0);
	}
}
