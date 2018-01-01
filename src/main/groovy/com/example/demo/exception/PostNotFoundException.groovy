package com.example.demo.exception

/**
 * Created by ksb on 2017. 12. 31..
 */
class PostNotFoundException extends RuntimeException {

    PostNotFoundException(String message){
        super(message)
    }

}