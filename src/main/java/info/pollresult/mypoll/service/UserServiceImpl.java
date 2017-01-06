package info.pollresult.mypoll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.pollresult.mypoll.model.User;
import info.pollresult.mypoll.repository.UserRepositoryImpl;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepositoryImpl userRepositoryImpl;
	
	@Override
	public void signup(User user) {
		userRepositoryImpl.signup(user);
	}

	@Override
	public boolean isUserExist(User user) {
		return userRepositoryImpl.isUserExit(user.getUserName());
	}

	@Override
	public boolean signin(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
