package com.huomai.web.controller.user;

import com.huomai.business.bo.HuomaiUserPromoteQueryBo;
import com.huomai.business.service.IHuomaiUserPromoteService;
import com.huomai.business.vo.HuomaiUserPromoteVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推广记录Controller
 *
 * @author huomai
 * @date 2021-07-06
 */
@Api(
    value = "推广记录控制器",
    tags = {"推广记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/promote")
public class HuomaiUserPromoteController extends BaseController {

  private final IHuomaiUserPromoteService iHuomaiUserPromoteService;

  /** 查询推广记录列表 */
  @ApiOperation("查询推广记录列表")
  @PreAuthorize("@ss.hasPermi('business:promote:list')")
  @GetMapping("/list")
  public TableDataInfo<HuomaiUserPromoteVo> list(@Validated HuomaiUserPromoteQueryBo bo) {
    return iHuomaiUserPromoteService.queryPageList(bo);
  }

//  /** 导出推广记录列表 */
//  @ApiOperation("导出推广记录列表")
//  @PreAuthorize("@ss.hasPermi('business:promote:export')")
//  @Log(title = "推广记录", businessType = BusinessType.EXPORT)
//  @GetMapping("/export")
//  public AjaxResult<HuomaiUserPromoteVo> export(@Validated HuomaiUserPromoteQueryBo bo) {
//    List<HuomaiUserPromoteVo> list = iHuomaiUserPromoteService.queryList(bo);
//    ExcelUtil<HuomaiUserPromoteVo> util =
//        new ExcelUtil<HuomaiUserPromoteVo>(HuomaiUserPromoteVo.class);
//    return util.exportExcel(list, "推广记录");
//  }
//
//  /** 获取推广记录详细信息 */
//  @ApiOperation("获取推广记录详细信息")
//  @PreAuthorize("@ss.hasPermi('business:promote:query')")
//  @GetMapping("/{id}")
//  public AjaxResult<HuomaiUserPromoteVo> getInfo(
//      @NotNull(message = "主键不能为空") @PathVariable("id") Long id) {
//    return AjaxResult.success(iHuomaiUserPromoteService.queryById(id));
//  }
//
//  /** 新增推广记录 */
//  @ApiOperation("新增推广记录")
//  @PreAuthorize("@ss.hasPermi('business:promote:add')")
//  @Log(title = "推广记录", businessType = BusinessType.INSERT)
//  @PostMapping()
//  public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserPromoteAddBo bo) {
//    return toAjax(iHuomaiUserPromoteService.insertByAddBo(bo) ? 1 : 0);
//  }
//
//  /** 修改推广记录 */
//  @ApiOperation("修改推广记录")
//  @PreAuthorize("@ss.hasPermi('business:promote:edit')")
//  @Log(title = "推广记录", businessType = BusinessType.UPDATE)
//  @PutMapping()
//  public AjaxResult<Void> edit(@Validated @RequestBody HuomaiUserPromoteEditBo bo) {
//    return toAjax(iHuomaiUserPromoteService.updateByEditBo(bo) ? 1 : 0);
//  }
//
//  /** 删除推广记录 */
//  @ApiOperation("删除推广记录")
//  @PreAuthorize("@ss.hasPermi('business:promote:remove')")
//  @Log(title = "推广记录", businessType = BusinessType.DELETE)
//  @DeleteMapping("/{ids}")
//  public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] ids) {
//    return toAjax(iHuomaiUserPromoteService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
//  }
}
