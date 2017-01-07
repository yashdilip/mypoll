package info.pollresult.mypoll.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class PollUser {
	@Id
	private ObjectId id;
	private String userName;
	private String fullName;
	private String mobileNumber;
	private String email;
	
	@DBRef(lazy = true)
	private List<Poll> user_polls;
	
	public PollUser() {
	}
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Poll> getUser_polls() {
		return user_polls;
	}
	public void setUser_polls(List<Poll> user_polls) {
		this.user_polls = user_polls;
	}
}
