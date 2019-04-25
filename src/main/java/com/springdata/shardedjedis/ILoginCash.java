package com.springdata.shardedjedis;

public interface ILoginCash {

	public void longin(LoginData loginDTO, int cashSeconds) throws Exception;

	public LoginData getLogInfo(int userId) throws Exception;

	public void longout(int userId) throws Exception;

}
