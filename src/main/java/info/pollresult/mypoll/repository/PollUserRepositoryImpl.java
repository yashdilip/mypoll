package info.pollresult.mypoll.repository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import info.pollresult.mypoll.model.Poll;
import info.pollresult.mypoll.model.PollUser;
import infopollresult.mypoll.Util.PollType;

@Repository
public class PollUserRepositoryImpl implements IPollUserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean signin(PollUser pollUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserExit(String user) {
		if (mongoTemplate.findOne(new Query(Criteria.where("userName").is(user)), PollUser.class) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void createPollUser(PollUser pollUser) {
		Poll p = new Poll();
		mongoTemplate.insert(p);		
		pollUser.setUser_polls(Arrays.asList(p));
		mongoTemplate.insert(pollUser);
	}

	@Override
	public PollUser findByUsername(String username) {
		return mongoTemplate.findOne(new Query(Criteria.where("userName").is(username)), PollUser.class);
	}

}
