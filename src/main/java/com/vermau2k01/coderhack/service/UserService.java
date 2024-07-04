package com.vermau2k01.coderhack.service;

import java.util.List;

import com.vermau2k01.coderhack.entity.Users;

public interface UserService {

    List<Users> getAllUsers();
    Users getUserById(String id);
    Users addUser(String userName);
    Users updateMarks(String id, int marks);
    void deleteUser(String id);

}
