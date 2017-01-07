package info.pollresult.mypoll.service;

public interface ISecurityService {
	public String findLoggedInUsername();
	public void autologin(String username, String password);
}
