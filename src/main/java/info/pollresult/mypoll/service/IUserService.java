package info.pollresult.mypoll.service;

import info.pollresult.mypoll.model.User;

public interface IUserService {
	public void signup(User user);
	public boolean isUserExist(User user);
	public boolean signin(User user);
	
}
