package info.pollresult.mypoll.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import info.pollresult.mypoll.model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, ObjectId>{

}
