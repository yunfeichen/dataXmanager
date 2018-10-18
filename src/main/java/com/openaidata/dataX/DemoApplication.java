package com.openaidata.dataX;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.context.annotation.Bean;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		System.out.println("War鍖呭惎鍔�");
		return builder.sources(DemoApplication.class);
	}
    
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.druid")
	public DataSource druid() {
		DruidDataSource ds = new DruidDataSource();
		return ds;
	}
	
	//start
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		Map<String, String> param = new HashMap<String, String>();
		param.put("loginUsername", "admin");
		param.put("loginPassword", "123456");
		param.put("allow", "127.0.0.1");
		param.put("deny", "33.31.51.88");
		servletRegistrationBean.setInitParameters(param);
		return servletRegistrationBean;
		
	}
	
	//鐢ㄤ簬鐩戝惉鑾峰彇搴旂敤鐨勬暟鎹紝 Filter鐢ㄤ簬鏁版嵁鏀堕泦锛孲ervlet鐢ㄤ簬灞曠幇鏁版嵁
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		Map<String, String> param = new HashMap<String,String>();
		
		param.put("exclusions", "*.png,*.woff,*.js,*.css, /druid/*");
		filterRegistrationBean.setInitParameters(param);
		return filterRegistrationBean;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
}
