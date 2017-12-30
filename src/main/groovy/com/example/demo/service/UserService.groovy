package com.example.demo.service

import com.example.demo.entity.User

/**
 * Created by ksb on 2017. 12. 30..
 */
interface UserService {

    User getByUsername(String username)
    User getByEmail(String email)
    User getCurrentUser()

}