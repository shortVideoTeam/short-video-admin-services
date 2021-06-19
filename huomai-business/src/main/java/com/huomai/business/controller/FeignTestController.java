package com.huomai.business.controller;

import com.huomai.business.feign.FeignTestService;
import com.huomai.common.core.domain.AjaxResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign测试controller
 *
 * @author huomai
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/feign/test")
public class FeignTestController {

	private final FeignTestService feignTestService;

	@GetMapping("/search/{wd}")
	public AjaxResult search(@PathVariable String wd) {
		String search = feignTestService.search(wd);
		return AjaxResult.success("操作成功", search);
	}
}
