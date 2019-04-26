package com.springdata.jedis;

import java.util.HashMap;
import java.util.Map;

public class LoginCashManager extends JedisManager implements ILoginCash {

	private static final String REDIS_USER = "user";

	@Override
	public boolean longin(LoginDTO loginDTO, int cashSeconds) throws Exception {

		boolean result = false;
		String key = REDIS_USER + ":" + loginDTO.getUserId();
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("code", loginDTO.getCode());
			map.put("name", loginDTO.getName());
			map.put("ip", loginDTO.getIp());
			hmset(RedisDBConstants.USER_DB_INDEX, key, map, cashSeconds);
			result = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;

	}

	@Override
	public LoginDTO getLogInfo(int userId) throws Exception {
		if (userId <= 0) {
			return null;
		}
		String key = REDIS_USER + ":" + userId;
		LoginDTO loginDTO = null;
		try {
			Map<String, String> map = hgetAll(RedisDBConstants.USER_DB_INDEX,
					key);
			if (map != null && !map.isEmpty()) {
				loginDTO = new LoginDTO();
				loginDTO.setUserId(userId);
				loginDTO.setCode(map.get("code"));
				loginDTO.setName(map.get("name"));
				loginDTO.setIp(map.get("ip"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return loginDTO;
	}

	@Override
	public boolean longout(int userId) throws Exception {
		if (userId <= 0) {
			return false;
		}
		String tokenKey = REDIS_USER + ":" + userId;
		boolean result = false;
		try {
			del(RedisDBConstants.USER_DB_INDEX, tokenKey);
			result = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;

	}

}
