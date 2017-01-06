package info.pollresult.mypoll.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import info.pollresult.mypoll.model.User;

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
		mongoTemplate.insert(user);
	}

}
