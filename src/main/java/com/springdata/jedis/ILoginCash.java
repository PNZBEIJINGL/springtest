package com.springdata.jedis;


public interface ILoginCash {

	public boolean longin(LoginDTO loginDTO, int cashSeconds) throws Exception;

	public LoginDTO getLogInfo(int userId) throws Exception;

	public boolean longout(int userId) throws Exception;

}
