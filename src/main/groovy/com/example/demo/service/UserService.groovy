package com.example.demo.service

import com.example.demo.entity.User

/**
 * Created by ksb on 2017. 12. 30..
 */
interface UserService {

    void save(User user)
    User getByUsername(String username)
    User getByEmail(String email)
    User getCurrentUser()

}