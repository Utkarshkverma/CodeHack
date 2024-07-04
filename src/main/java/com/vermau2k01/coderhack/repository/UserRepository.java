package com.vermau2k01.coderhack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vermau2k01.coderhack.entity.Users;

public interface UserRepository extends MongoRepository<Users,String>{
    
}