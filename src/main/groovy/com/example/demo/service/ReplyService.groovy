package com.example.demo.service

import com.example.demo.entity.Reply

/**
 * Created by ksb on 2017. 12. 30..
 */
interface ReplyService {

    List<Reply> getAll(long postId)
    void create(Reply target)
    void update(Reply target)
    void delete(long id)

}