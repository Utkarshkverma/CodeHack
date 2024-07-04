package com.vermau2k01.coderhack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermau2k01.coderhack.entity.Badge;
import com.vermau2k01.coderhack.entity.Users;
import com.vermau2k01.coderhack.exception.InvalidMarksException;
import com.vermau2k01.coderhack.exception.UserNotFoundException;
import com.vermau2k01.coderhack.repository.UserRepository;
import com.vermau2k01.coderhack.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAllUsers() {
        List<Users> list = userRepository.findAll();
        list.sort((a,b)->b.getMarks()-a.getMarks());
        return list;
    }

    @Override
    public Users getUserById(String id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public Users addUser(String userName) {
        Users user = new Users();
        user.setName(userName);
        user.setMarks(0);
        return userRepository.save(user);
    }

    @Override
    public Users updateMarks(String id, int marks) {
    Users user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    if(marks<0 || marks>100)
    throw new InvalidMarksException();

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
