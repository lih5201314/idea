/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: WebConfigurer
 * Author:   李辉
 * Date:     2019/8/10 10:40
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 李辉           修改时间           版本号              描述
 */
package com.jk.intercepors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 李辉
 * @create 2019/8/10
 * @since 1.0.0
 */
@Configuration
public class WebConfigurer  implements WebMvcConfigurer{

    @Autowired
    private LoginInterceptor loginInterceptor;




        // 这个方法是用来配置静态资源的，比如html，js，css，等等
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
        }

        // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            // addPathPatterns("/**") 表示拦截所有的请求，
            // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
            registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/page/index","/user/getcode","/user/login");
        }



}