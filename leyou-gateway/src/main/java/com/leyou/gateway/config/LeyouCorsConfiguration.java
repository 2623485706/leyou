package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class LeyouCorsConfiguration {
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration configuration=new CorsConfiguration();

        configuration.addAllowedOrigin("http://manage.leyou.com");
        configuration.setAllowCredentials(true);//允许携带cookie
        configuration.addAllowedMethod("*");//代表所有请求方法
        configuration.addAllowedHeader("*");//允许携带任何头信息
        //初始化cors
        UrlBasedCorsConfigurationSource configurationSource=new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",configuration);
        //参数cors 配置源对象
        return new CorsFilter(configurationSource);
    }
}
