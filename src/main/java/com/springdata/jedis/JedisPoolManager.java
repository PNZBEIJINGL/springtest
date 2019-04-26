package com.springdata.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolManager {

	private static String REDISDB_IP = "192.168.62.44";
	private static int REDISDB_PORT = 6379;

	private JedisPool jedisPool;

	public JedisPoolManager() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);
		jedisPool = new JedisPool(config, REDISDB_IP, REDISDB_PORT);
	}

	public Jedis getJedis() throws Exception {
		try {
			Jedis jedis = jedisPool.getResource();
			return jedis;
		} catch (Exception e) {
			throw e;
		}
	}

	public void releaseJedis(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}
}
