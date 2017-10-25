package com.example.demo;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class I18Config extends WebMvcConfigurerAdapter {
	@Bean
	ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource msgSource=new ReloadableResourceBundleMessageSource();
		msgSource.addBasenames("classpath:/i18n/messages");
		msgSource.setCacheSeconds(1800);
		msgSource.setDefaultEncoding("UTF-8");
		return msgSource;
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver slr=new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
	
	public LocaleChangeInterceptor localeChangeInterceptor(){
		LocaleChangeInterceptor lci=new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(localeChangeInterceptor());
	}
}
