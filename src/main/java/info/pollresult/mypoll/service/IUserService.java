package info.pollresult.mypoll.service;

import info.pollresult.mypoll.model.User;

public interface IUserService {
	void save(User user);
	User findByUsername(String username);
}
