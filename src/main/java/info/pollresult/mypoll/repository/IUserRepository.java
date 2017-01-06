package info.pollresult.mypoll.repository;

import info.pollresult.mypoll.model.User;

public interface IUserRepository {
	public boolean signin(User user);
	public boolean isUserExit(String user);
	public void signup(User user);
}
