package com.example.demo.repository

import com.example.demo.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ksb on 2017. 12. 22..
 */
interface PostRepository extends JpaRepository<Post, Long> {
}
