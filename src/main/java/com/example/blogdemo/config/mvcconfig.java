package com.example.blogdemo.config;

import com.example.blogdemo.Utils.LoginIntercipter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class mvcconfig implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册拦截器
//        LoginIntercipter loginIntercipter = new LoginIntercipter();
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginIntercipter);
//        //定义拦截路径
//        ///**是拦截默认的静态资源路径
//        interceptorRegistration.addPathPatterns("/**");
//        //排除路径
//        List<String> list = new ArrayList<>();
//        list.add("/");
//        list.add("/login");
//        interceptorRegistration.excludePathPatterns(list);
//        //排除资源请求
//       // interceptorRegistration.excludePathPatterns("/")
//
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST","GET","PUT","DELETE","ORIGINS")
                .maxAge(3600)
                .allowedHeaders("*")
                .exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options")
                .allowCredentials(true);
    }
}
