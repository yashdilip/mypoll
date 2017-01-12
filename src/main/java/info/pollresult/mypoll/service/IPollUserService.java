package info.pollresult.mypoll.service;

import info.pollresult.mypoll.model.PollUser;

public interface IPollUserService {
	public boolean isUserExist(PollUser pollUser);
	public void createPollUser(PollUser user);
	public PollUser findByUsername(String username);
	
}
