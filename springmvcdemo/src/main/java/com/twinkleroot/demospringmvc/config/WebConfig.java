package com.twinkleroot.demospringmvc.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 스프링 부트의 MVC 기본 설정 + 추가적인 설정
@Configuration
// 스프링 MVC 재정의
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
}
