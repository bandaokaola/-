package com.quark.porent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.quark.porent.interceptor.LoginInterceptor;

/**
 * @Author LHR
 * Create By 2017/8/27
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer{


    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns(
                "/posts/add",
                "/user/set",
                "/user/seticon",
                "/user/setpsw",
                "/user/message",
                "/chat");
    }
}
