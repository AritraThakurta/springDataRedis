package com.springredis.spring_redis_example.repository;

import com.springredis.spring_redis_example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    public static final String HASH_KEY = "product";

    @Autowired
    private  RedisTemplate template;

    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;

    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);

    }

    public Product getProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProduct(int id){
         template.opsForHash().delete(HASH_KEY,id);
         return "product removed";
    }
}




