package com.hita.tata.common.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拦截器配置
 * @author abel
 */
@Configuration
public class FilterConfig {
    
    @Bean
    public FilterRegistrationBean loginSessionFilter() {//这个类应该是Spring给我们拿来初测filter的
        
        FilterRegistrationBean registration = new FilterRegistrationBean();//新建过滤器的注册类
        
        registration.setFilter(new WebFilter());//添加我们写好的filter
        
        registration.addUrlPatterns("/block/test");//设置filter的过滤的url模式
        
        return registration;//返回这个就是Spring会帮你注入的那个对象
        
    }
    
}