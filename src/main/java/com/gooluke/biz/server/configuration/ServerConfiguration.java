package com.gooluke.biz.server.configuration;

import com.gooluke.biz.server.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 咕噜科
 * ClassName: ServerConfiguration
 * date: 2023-08-15 22:33
 * Description:
 * version 1.0
 */
@Configuration
public class ServerConfiguration implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePathPatterns = {
                "/login",
                "/logout",
                "/op/**"
        };

        // 注册拦截器
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePathPatterns)
                .order(1)
        ;
    }

}
