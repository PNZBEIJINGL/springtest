package com.springdata;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class UserDaoImpl {
	protected RedisTemplate<Serializable, Serializable> redisTemplate;

	public void setRedisTemplate(
			RedisTemplate<Serializable, Serializable> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void addUser(final User user) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {

				byte[] key = redisTemplate.getStringSerializer().serialize(
						"user.uid." + user.getId());
				byte[] value = redisTemplate.getStringSerializer().serialize(
						user.getCode());
				connection.set(key, value);
				return null;
			}
		});
	}

	public User getUser(final int id) {
		return redisTemplate.execute(new RedisCallback<User>() {
			@Override
			public User doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize(
						"user.uid." + id);
				if (connection.exists(key)) {
					byte[] value = connection.get(key);
					String code = redisTemplate.getStringSerializer()
							.deserialize(value);
					User user = new User();
					user.setCode(code);
					user.setId(id);
					return user;
				}
				return null;
			}
		});
	}
}
