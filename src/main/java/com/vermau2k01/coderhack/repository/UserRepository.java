package com.vermau2k01.coderhack.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vermau2k01.coderhack.entity.Users;


@Repository
public interface UserRepository extends MongoRepository<Users,String> {

}
