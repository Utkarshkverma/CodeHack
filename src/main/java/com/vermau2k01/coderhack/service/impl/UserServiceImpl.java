package com.vermau2k01.coderhack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermau2k01.coderhack.entity.Badge;
import com.vermau2k01.coderhack.entity.MarksRequest;
import com.vermau2k01.coderhack.entity.UserRequest;
import com.vermau2k01.coderhack.entity.Users;
import com.vermau2k01.coderhack.exception.UserNotFoundException;
import com.vermau2k01.coderhack.repository.UserRepository;
import com.vermau2k01.coderhack.service.UserService;


@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<Users> findAllUsers()
    {
        List<Users> list =  userRepository.findAll();
        list.sort((a,b)->b.getMarks()-a.getMarks());
        return list;
    }

    @Override
    public Users getUserById(String id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public Users addUser(UserRequest userRequest) {
        Users user = new Users();
        user.setName(userRequest.getName());
        user.setMarks(0);
        return userRepository.save(user);
    }

    @Override
    public Users updateMarks(String id, MarksRequest marksRequest) {
    Users user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    int marks  = marksRequest.getMarks();
    user.setMarks(marks);
    if(marks >= 60)
    user.getBadges().add(Badge.CODE_MASTER);
    else if(marks >=30)
    user.getBadges().add(Badge.CODE_CHAMP);
    else if(marks >= 1)
    user.getBadges().add(Badge.CODE_NINJA);

    return userRepository.save(user);

    }

    @Override
    public void deleteUser(String id) {
    Users user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    userRepository.delete(user);
    }

}
