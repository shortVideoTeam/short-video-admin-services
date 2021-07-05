package com.huomai.web.controller.common;

import com.huomai.business.bo.HuomaiPromoteConfigAddBo;
import com.huomai.business.bo.HuomaiPromoteConfigEditBo;
import com.huomai.business.bo.HuomaiPromoteConfigQueryBo;
import com.huomai.business.service.IHuomaiPromoteConfigService;
import com.huomai.business.vo.HuomaiPromoteConfigVo;
import com.huomai.common.annotation.Log;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.enums.BusinessType;
import com.huomai.common.utils.poi.ExcelUtil;
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
import java.util.List;

/**
 * 推广配置Controller
 *
 * @author huomai
 * @date 2021-07-05
 */
@Api(
    value = "推广配置控制器",
    tags = {"推广配置管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/promote/config")
public class HuomaiPromoteConfigController extends BaseController {

  private final IHuomaiPromoteConfigService iHuomaiPromoteConfigService;

  /** 查询推广配置列表 */
  @ApiOperation("查询推广配置列表")
  @PreAuthorize("@ss.hasPermi('business:config:list')")
  @GetMapping("/list")
  public TableDataInfo<HuomaiPromoteConfigVo> list(@Validated HuomaiPromoteConfigQueryBo bo) {
    return iHuomaiPromoteConfigService.queryPageList(bo);
  }

  /** 导出推广配置列表 */
  @ApiOperation("导出推广配置列表")
  @PreAuthorize("@ss.hasPermi('business:config:export')")
  @Log(title = "推广配置", businessType = BusinessType.EXPORT)
  @GetMapping("/export")
  public AjaxResult<HuomaiPromoteConfigVo> export(@Validated HuomaiPromoteConfigQueryBo bo) {
    List<HuomaiPromoteConfigVo> list = iHuomaiPromoteConfigService.queryList(bo);
    ExcelUtil<HuomaiPromoteConfigVo> util =
        new ExcelUtil<HuomaiPromoteConfigVo>(HuomaiPromoteConfigVo.class);
    return util.exportExcel(list, "推广配置");
  }

  /** 获取推广配置详细信息 */
  @ApiOperation("获取推广配置详细信息")
  @PreAuthorize("@ss.hasPermi('business:config:query')")
  @GetMapping("/{id}")
  public AjaxResult<HuomaiPromoteConfigVo> getInfo(
      @NotNull(message = "主键不能为空") @PathVariable("id") Long id) {
    return AjaxResult.success(iHuomaiPromoteConfigService.queryById(id));
  }

  /** 新增推广配置 */
  @ApiOperation("新增推广配置")
  @PreAuthorize("@ss.hasPermi('business:config:add')")
  @Log(title = "推广配置", businessType = BusinessType.INSERT)
  @PostMapping()
  public AjaxResult<Void> add(@Validated @RequestBody HuomaiPromoteConfigAddBo bo) {
    return toAjax(iHuomaiPromoteConfigService.insertByAddBo(bo) ? 1 : 0);
  }

  /** 修改推广配置 */
  @ApiOperation("修改推广配置")
  @PreAuthorize("@ss.hasPermi('business:config:edit')")
  @Log(title = "推广配置", businessType = BusinessType.UPDATE)
  @PutMapping()
  public AjaxResult<Void> edit(@Validated @RequestBody HuomaiPromoteConfigEditBo bo) {
    return toAjax(iHuomaiPromoteConfigService.updateByEditBo(bo) ? 1 : 0);
  }

  /** 删除推广配置 */
  @ApiOperation("删除推广配置")
  @PreAuthorize("@ss.hasPermi('business:config:remove')")
  @Log(title = "推广配置", businessType = BusinessType.DELETE)
  @DeleteMapping("/{ids}")
  public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] ids) {
    return toAjax(
        iHuomaiPromoteConfigService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
  }
}
