package com.huomai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author huomai
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HmAdminApplication {
	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(HmAdminApplication.class, args);
		System.out.println("(♥◠‿◠)ﾉﾞ  huomai启动成功   ლ(´ڡ`ლ)ﾞ");
	}
}
