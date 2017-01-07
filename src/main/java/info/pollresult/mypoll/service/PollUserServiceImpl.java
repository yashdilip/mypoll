package info.pollresult.mypoll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.pollresult.mypoll.model.PollUser;
import info.pollresult.mypoll.repository.PollUserRepositoryImpl;

@Service
public class PollUserServiceImpl implements IPollUserService {

	@Autowired
	private PollUserRepositoryImpl pollUserRepositoryImpl;
	
	@Override
	public void signup(PollUser pollUser) {
		pollUserRepositoryImpl.signup(pollUser);
	}

	@Override
	public boolean isUserExist(PollUser pollUser) {
		return pollUserRepositoryImpl.isUserExit(pollUser.getUserName());
	}

	@Override
	public boolean signin(PollUser pollUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
