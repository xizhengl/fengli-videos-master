package com.fengli.video;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fengli.video.controller.interceptor.MiniInterceptor;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:/META-INF/resources/")
				.addResourceLocations("file:F:/fengli_videos_dev/");
	}

//	@Bean(initMethod="init")
//	public ZKCuratorClient zkCuratorClient() {
//		return new ZKCuratorClient();
//	}
//

	/**
	 * 注册到Spring 中
	 * @return
	 */
	@Bean
	public MiniInterceptor miniInterceptor() {
		return new MiniInterceptor();
	}

	/**
	 * 注册拦截器
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(miniInterceptor()).addPathPatterns("/user/**")
				       .addPathPatterns("/video/upload", "/video/uploadCover",
				    		   			"/video/userLike", "/video/userUnLike",
				    		   			"/video/saveComment")
								  .addPathPatterns("/bgm/**")
								  .excludePathPatterns("/user/queryPublisher")
								  .excludePathPatterns("/wxLogin");
		
		super.addInterceptors(registry);
	}

}
