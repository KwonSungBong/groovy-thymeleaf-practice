package com.example.demo.repository

import com.example.demo.entity.Reply
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Created by ksb on 2017. 12. 22..
 */
interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findByPostIdAndEnabledTrue(Long postId);

    @Modifying
    @Query("update Reply r set r.content = :content where r.id = :id")
    int update(@Param("id") Long id, @Param("content") String content);

    @Modifying
    @Query("update Reply r set r.enabled = false where r.id = :id")
    int remove(@Param("id") Long id);

}