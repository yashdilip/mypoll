package info.pollresult.mypoll.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import info.pollresult.mypoll.model.Poll;
import info.pollresult.mypoll.model.User;
import infopollresult.mypoll.Util.PollType;

@Repository
public class UserRepositoryImpl implements IUserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean signin(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserExit(String user) {
		if (mongoTemplate.findOne(new Query(Criteria.where("userName").is(user)), User.class) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void signup(User user) {
		Poll p = new Poll();
		p.setTitle("test");
		p.setDescription("test desc");
		p.setPollType(PollType.YES_NO);
		mongoTemplate.insert(p);
		
		user.setUser_polls(Arrays.asList(p));
		mongoTemplate.insert(user);
	}

}
