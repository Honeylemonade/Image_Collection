package com.example.demo.interceptor;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig:
 *
 * @author XvYanPeng
 * @date 2019/8/16 12:49
 */
@Configuration
public class InterceptionConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInInterceptor())
                //拦截请求
                .addPathPatterns("/**")
                //放行请求
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/register/**")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/webjars/springfox-swagger-ui/**")
                .excludePathPatterns("/v2/api-docs")
                .excludePathPatterns("/**.png");

    }
}
