package com.example.demo.service.impl

import com.example.demo.entity.Post
import com.example.demo.repository.PostRepository
import com.example.demo.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

import javax.transaction.Transactional

/**
 * Created by ksb on 2017. 12. 30..
 */
@Service
class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository

    @Override
    Page<Post> getAll(Pageable pageable, long boardId, String searchWord) {
        postRepository.findByBoardIdAndNameContainingAndEnabledTrue(pageable, boardId, searchWord)
    }

    @Override
    Post get(long postId) {
        postRepository.findOne(postId)
    }

    @Override
    long create(Post target) {
        postRepository.save(target)
        target.getId()
    }

    @Override
    @Transactional
    void update(Post target) {
        postRepository.update(target.getId(), target.getName(), target.getContent())
    }

    @Override
    @Transactional
    void delete(long id) {
        postRepository.remove(id)
    }
}
