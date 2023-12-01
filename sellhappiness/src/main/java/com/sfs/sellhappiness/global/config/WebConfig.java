package com.sfs.sellhappiness.global.config;

import com.sfs.sellhappiness.global.infra.AppInitListener;
import jakarta.servlet.ServletContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import javax.servlet.ServletContextListener;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> appInitListener() {
        ServletListenerRegistrationBean<ServletContextListener> srb
                = new ServletListenerRegistrationBean<>();
        srb.setListener(new AppInitListener());
        return srb;
    }

    // 기본 view 설정
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/user/login_form").setViewName("user/login");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(null).addPathPatterns("/dept/**");
//    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500", "http://127.0.0.1:4000", "http://127.0.0.1:9000", "http://127.0.0.1:9001")
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.HEAD.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name())
                .allowCredentials(true);
    }

    // 나중에 formatter 필요할시 추가
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new BoardTypeConverter());
//    }
}
