package info.pollresult.mypoll.service;

import info.pollresult.mypoll.model.PollUser;

public interface IPollUserService {
	public void signup(PollUser pollUser);
	public boolean isUserExist(PollUser pollUser);
	public boolean signin(PollUser pollUser);
	
}
