package com.mycomp.billeezz.zuulapiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableZuulProxy
//@Enablediscovery 
@SpringBootApplication
public class ZuulApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiServerApplication.class, args);
	}
	
	@Bean
	public Sampler getAlwaysSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
