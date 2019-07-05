package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Lock;

import redis.clients.jedis.Jedis;
 
public class RedisLockImpl  {
  
	/**
	 * 加锁
	 * */
	public boolean tryLock(Lock lock) {
		do {
			Jedis  jedis = new Jedis ("192.168.213.111",6379); 
			Long aa = jedis.setnx(lock.getKey(), lock.getValue());
			if(aa==1) {
				return true;
			}					
		} while (true);
	}
	
	/**
	 * 去锁
	 * */
	public void unLock(Lock lock) {
		Jedis  jedis = new Jedis ("192.168.213.111",6379); 
		jedis.del(lock.getKey());
	}
}
