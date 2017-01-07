package info.pollresult.mypoll.repository;

import info.pollresult.mypoll.model.PollUser;

public interface IPollUserRepository {
	public boolean signin(PollUser pollUser);
	public boolean isUserExit(String user);
	public void signup(PollUser pollUser);
}
