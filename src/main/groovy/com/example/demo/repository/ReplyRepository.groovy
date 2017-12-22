package com.example.demo.repository

import com.example.demo.entity.Reply
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ksb on 2017. 12. 22..
 */
interface ReplyRepository extends JpaRepository<Reply, Long> {

}