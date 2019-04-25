package com.springdata.shardedjedis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.ShardedJedis;

public class LoginCashManager extends RedisTemplate implements ILoginCash {

	private static final String REDIS_USER = "user";

	@Override
	public String createKey(int id) {
		return REDIS_USER + ":" + id;
	}

	@Override
	public LoginData getLogInfo(int userId) {
		if (userId <= 0) {
			return null;
		}
		ShardedJedis shardedJedis = null;
		LoginData loginDTO = null;
		try {
			String key = createKey(userId);
			shardedJedis = getShardedJedis();
			Map<String, String> map = shardedJedis.hgetAll(key);
			if (map != null && !map.isEmpty()) {
				loginDTO = new LoginData();
				loginDTO.setUserId(userId);
				loginDTO.setCode(map.get("code"));
				loginDTO.setName(map.get("name"));
				loginDTO.setIp(map.get("ip"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			release(shardedJedis);
		}
		return loginDTO;
	}

	@Override
	public void longout(int userId) {

	}

	@Override
	public void longin(LoginData loginDTO, int cashSeconds) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = getShardedJedis();
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", loginDTO.getCode());
			map.put("name", loginDTO.getName());
			map.put("ip", loginDTO.getIp());
			String key = createKey(loginDTO.getUserId());

			shardedJedis.hmset(key, map);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			release(shardedJedis);
		}

	}

}
