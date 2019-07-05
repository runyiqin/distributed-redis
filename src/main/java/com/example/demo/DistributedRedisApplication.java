package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DistributedRedisApplication {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(DistributedRedisApplication.class, args);
	}
	
	@RequestMapping("/hello")
	public void hello(String name){
		redisTemplate.opsForValue().set("name", name);
		System.out.println(redisTemplate.opsForValue().get("name"));
	}
	
	 
	

}
