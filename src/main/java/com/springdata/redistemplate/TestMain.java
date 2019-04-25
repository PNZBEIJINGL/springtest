package com.springdata.redistemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/main/java/com/springdata/application.xml");
		UserDaoImpl userDAO = (UserDaoImpl) ctx.getBean("userDAO");
		System.out.println("add user id=1001 code=1002");
		User user = new User();
		user.setId(1001);
		user.setCode("1002");
		userDAO.addUser(user);
		User user2 = userDAO.getUser(1000);
		System.out.print("id="+user2.getId());
		System.out.println(" code="+user2.getCode());
	}
}
