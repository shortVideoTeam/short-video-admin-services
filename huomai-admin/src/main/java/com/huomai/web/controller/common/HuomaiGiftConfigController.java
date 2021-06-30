package com.huomai.web.controller.common;

import com.huomai.business.bo.HuomaiGiftConfigAddBo;
import com.huomai.business.bo.HuomaiGiftConfigEditBo;
import com.huomai.business.bo.HuomaiGiftConfigQueryBo;
import com.huomai.business.service.IHuomaiGiftConfigService;
import com.huomai.business.vo.HuomaiGiftConfigVo;
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
 * 红包金额配置Controller
 *
 * @author huomai
 * @date 2021-06-30
 */
@Api(
    value = "红包金额配置控制器",
    tags = {"红包金额配置管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/walle")
public class HuomaiGiftConfigController extends BaseController {

  private final IHuomaiGiftConfigService iHuomaiGiftConfigService;

  /** 查询红包金额配置列表 */
  @ApiOperation("查询红包金额配置列表")
  @PreAuthorize("@ss.hasPermi('system:config:list')")
  @GetMapping("/list")
  public TableDataInfo<HuomaiGiftConfigVo> list(@Validated HuomaiGiftConfigQueryBo bo) {
    return iHuomaiGiftConfigService.queryPageList(bo);
  }

  /** 导出红包金额配置列表 */
  @ApiOperation("导出红包金额配置列表")
  @PreAuthorize("@ss.hasPermi('system:config:export')")
  @Log(title = "红包金额配置", businessType = BusinessType.EXPORT)
  @GetMapping("/export")
  public AjaxResult<HuomaiGiftConfigVo> export(@Validated HuomaiGiftConfigQueryBo bo) {
    List<HuomaiGiftConfigVo> list = iHuomaiGiftConfigService.queryList(bo);
    ExcelUtil<HuomaiGiftConfigVo> util =
        new ExcelUtil<HuomaiGiftConfigVo>(HuomaiGiftConfigVo.class);
    return util.exportExcel(list, "红包金额配置");
  }

  /** 获取红包金额配置详细信息 */
  @ApiOperation("获取红包金额配置详细信息")
  @PreAuthorize("@ss.hasPermi('system:config:query')")
  @GetMapping("/{id}")
  public AjaxResult<HuomaiGiftConfigVo> getInfo(
      @NotNull(message = "主键不能为空") @PathVariable("id") Long id) {
    return AjaxResult.success(iHuomaiGiftConfigService.queryById(id));
  }

  /** 新增红包金额配置 */
  @ApiOperation("新增红包金额配置")
  @PreAuthorize("@ss.hasPermi('system:config:add')")
  @Log(title = "红包金额配置", businessType = BusinessType.INSERT)
  @PostMapping()
  public AjaxResult<Void> add(@Validated @RequestBody HuomaiGiftConfigAddBo bo) {
    return toAjax(iHuomaiGiftConfigService.insertByAddBo(bo) ? 1 : 0);
  }

  /** 修改红包金额配置 */
  @ApiOperation("修改红包金额配置")
  @PreAuthorize("@ss.hasPermi('system:config:edit')")
  @Log(title = "红包金额配置", businessType = BusinessType.UPDATE)
  @PutMapping()
  public AjaxResult<Void> edit(@Validated @RequestBody HuomaiGiftConfigEditBo bo) {
    return toAjax(iHuomaiGiftConfigService.updateByEditBo(bo) ? 1 : 0);
  }

  /** 删除红包金额配置 */
  @ApiOperation("删除红包金额配置")
  @PreAuthorize("@ss.hasPermi('system:config:remove')")
  @Log(title = "红包金额配置", businessType = BusinessType.DELETE)
  @DeleteMapping("/{ids}")
  public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] ids) {
    return toAjax(iHuomaiGiftConfigService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
  }
}
