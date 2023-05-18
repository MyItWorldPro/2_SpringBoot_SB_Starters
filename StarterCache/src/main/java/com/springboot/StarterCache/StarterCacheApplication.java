package com.springboot.StarterCache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StarterCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterCacheApplication.class, args);
	}

}
