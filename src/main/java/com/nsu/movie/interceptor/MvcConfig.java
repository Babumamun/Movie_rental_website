package com.nsu.movie.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns(
                "/addtocart","/tocart","/toorder","/delcart","/order","/orderlist"
        );
        registration.excludePathPatterns(
                "/login",
                "/tologin",
                "/login.html",
                "/error",
                "/error.html",
                "/html/*.html",
                "/js/*.js",
                "/css/*.css",
                "/fonts/*.*",
                "/pictures/*.*"
        );
    }
}