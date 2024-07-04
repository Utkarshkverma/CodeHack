package com.vermau2k01.coderhack.service;

import java.util.List;

import com.vermau2k01.coderhack.entity.MarksRequest;
import com.vermau2k01.coderhack.entity.UserRequest;
import com.vermau2k01.coderhack.entity.Users;

public interface UserService {
    List<Users> findAllUsers();
    Users getUserById(String id);
    Users addUser(UserRequest userRequest);
    Users updateMarks(String id, MarksRequest marksRequest);
    void deleteUser(String id);
}
