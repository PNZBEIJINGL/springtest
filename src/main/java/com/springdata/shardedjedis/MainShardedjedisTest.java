package com.springdata.shardedjedis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainShardedjedisTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/main/java/com/springdata/shardedjedis/application.xml");
		LoginCashManager loginserver = (LoginCashManager) ctx
				.getBean("loginCashManager");
		
		System.out.println("\"========MainShardedjedisTest  START\"========");
		LoginData loginDTO = new LoginData();
		loginDTO.setUserId(1000);
		loginDTO.setCode("C1000");
		loginDTO.setName("LIUY");
		loginDTO.setIp("127.0.01");
		loginserver.longin(loginDTO, -1);

		System.out.println("======== After login========");
		System.out.println("======== login  ============");

		LoginData login = loginserver.getLogInfo(1000);
		System.out.println("id=" + login.getUserId());
		System.out.println("code=" + login.getCode());
		System.out.println("name=" + login.getName());
		System.out.println("loginIP=" + login.getIp());

		System.out.println("========MainShardedjedisTest  END");

	}
}
