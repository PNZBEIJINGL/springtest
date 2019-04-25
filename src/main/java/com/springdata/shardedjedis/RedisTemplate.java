package com.springdata.shardedjedis;

		import redis.clients.jedis.ShardedJedis;
		import redis.clients.jedis.ShardedJedisPool;

public abstract class RedisTemplate {

	protected ShardedJedisPool shardedJedisPool;

	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

	public abstract String createKey(int id);

	public ShardedJedis getShardedJedis() {
		return shardedJedisPool.getResource();
	}

	public void release(ShardedJedis shardedJedis) {
		if (shardedJedis != null) {
			shardedJedis.close();
		}
	}

}
