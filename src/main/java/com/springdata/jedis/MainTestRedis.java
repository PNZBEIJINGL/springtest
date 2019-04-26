package com.springdata.jedis;


public class MainTestRedis {

	public static void main(String[] args) throws Exception {
		
		
		
		
		LoginCashManager logincash = new LoginCashManager();
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserId(1000);
		loginDTO.setCode("1003");
		loginDTO.setName("LIUY");
		loginDTO.setIp("127.0.0.1");
		logincash.longin(loginDTO,50);
		
		LoginDTO login =logincash.getLogInfo(1000);
		System.out.println("id="+login.getUserId());
		System.out.println("code="+login.getCode());
		System.out.println("name="+login.getName());
		System.out.println("loginIP="+login.getIp());
	}
}
