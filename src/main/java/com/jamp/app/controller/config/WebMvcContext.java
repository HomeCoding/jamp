package com.jamp.app.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jamp.app.converter.LocalDateTimeConverter;

@Configuration
@EnableWebMvc

//@EnableAsync
//@EnableAspectJAutoProxy
class WebMvcContext extends WebMvcConfigurerAdapter {
 
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm"));
    }

}