package com.springdata.jedis;

import java.util.Map;

import redis.clients.jedis.Jedis;

public class JedisManager {

	private JedisPoolManager pool = new JedisPoolManager();

	protected void set(int dbIndex, String key, String value, int cashSeconds)
			throws Exception {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.select(dbIndex);
			jedis.set(key, value);
			if (cashSeconds > 0) {
				jedis.expire(key, cashSeconds);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			pool.releaseJedis(jedis);
		}
	}

	protected String get(int dbIndex, String key) throws Exception {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.select(dbIndex);
			return jedis.get(key);
		} catch (Exception e) {
			throw e;
		} finally {
			pool.releaseJedis(jedis);
		}
	}

	protected void delete(int dbIndex, String key) throws Exception {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.select(dbIndex);
			jedis.del(key);
		} catch (Exception e) {
			throw e;
		} finally {
			pool.releaseJedis(jedis);
		}
	}

	protected Map<String, String> hgetAll(int dbIndex, String key)
			throws Exception {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.select(dbIndex);
			return jedis.hgetAll(key);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		} finally {
			pool.releaseJedis(jedis);
		}
	}

	protected void hset(int dbIndex, String key, String field, String value)
			throws Exception {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.select(dbIndex);
			jedis.hset(key, field, value);
		} catch (Exception e) {
			throw e;
		} finally {
			pool.releaseJedis(jedis);
		}
	}

	protected void hmset(int dbIndex, String key, Map<String, String> maps,
			int cacheSeconds) throws Exception {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.select(dbIndex);
			jedis.hmset(key, maps);
			if (cacheSeconds >= 0) {
				jedis.expire(key, cacheSeconds);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			pool.releaseJedis(jedis);
		}
	}

	protected void del(int dbIndex, String key) throws Exception {
		Jedis jedis = null;
		try {
			jedis = pool.getJedis();
			jedis.select(dbIndex);
			jedis.del(key);
		} catch (Exception e) {
			throw e;
		} finally {
			pool.releaseJedis(jedis);
		}
	}

	// //////TESTINT
	public static void main(String[] args) throws Exception {
		JedisManager manager = new JedisManager();
//		manager.set(1, "name", "zhangs", 2);
//		System.out.println(manager.get(1, "name"));
//		try {
//			System.out.println("SLEEP 1s");
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//		}
//		System.out.println("" + manager.get(1, "name"));
//
//		manager.hset(1, "user:1", "code", "1001");
//		manager.hset(1, "user:1", "name", "liuy");
//		manager.hset(1, "user:1", "logtime", new Date().toString());
//
//		manager.hset(1, "user:2", "code", "1002");
//		manager.hset(1, "user:2", "name", "changys");
//		manager.hset(1, "user:2", "logtime", new Date().toString());

		Map<String, String> user1 = manager.hgetAll(1, "user:1000");
		for (String key : user1.keySet()) {
			System.out.println(key + ":" + user1.get(key));
		}
	}

}
