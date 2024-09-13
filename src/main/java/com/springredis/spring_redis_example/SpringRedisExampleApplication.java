package com.springredis.spring_redis_example;

import com.springredis.spring_redis_example.entity.Product;
import com.springredis.spring_redis_example.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringRedisExampleApplication {

	@Autowired
	private ProductDao dao;

	@PostMapping("/save")
	public Product save(@RequestBody Product product){
		return dao.save(product);
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringRedisExampleApplication.class, args);
	}



}
