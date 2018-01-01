package com.example.demo.service

import com.example.demo.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

/**
 * Created by ksb on 2017. 12. 30..
 */
interface PostService {

    Page<Post> getAll(Pageable pageable, long boardId, String searchWord)
    Post get(long postId)
    long create(Post target)
    void update(Post target)
    void delete(long id)

}