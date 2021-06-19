package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 敏感词对象 huomai_sensitive
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_sensitive")
public class HuomaiSensitive implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id")
	private Long id;

	/**
	 * 内容
	 */
	private String content;

}
