package com.example.demo.service.impl

import com.example.demo.entity.Reply
import com.example.demo.repository.ReplyRepository
import com.example.demo.service.ReplyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

/**
 * Created by ksb on 2017. 12. 30..
 */
@Service
class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyRepository replyRepository

    @Override
    List<Reply> getAll(long postId) {
        replyRepository.findByPostIdAndEnabledTrue(postId)
    }

    @Override
    void create(Reply target) {
        replyRepository.save(target)
    }

    @Override
    @Transactional
    void update(Reply target) {
        replyRepository.save(target.getId(), target.getContent())
    }

    @Override
    @Transactional
    void delete(long id) {
        replyRepository.remove(id)
    }
}
