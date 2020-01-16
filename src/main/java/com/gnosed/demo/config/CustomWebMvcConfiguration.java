package com.gnosed.demo.config;

import com.gnosed.demo.constant.Constant;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Gnosed Lu
 * @Date 2020/1/13
 */
@Configuration
public class CustomWebMvcConfiguration implements WebMvcConfigurer {
    /**
     * 所有请求都允许跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

    /**
     * 图片路径与本地关联
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**")
                .addResourceLocations("file:" + Constant.IMG_FOLDER);
    }
}
