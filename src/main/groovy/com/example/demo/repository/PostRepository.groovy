package com.example.demo.repository

import com.example.demo.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * Created by ksb on 2017. 12. 22..
 */
@Repository
interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findByBoardIdAndNameContainingAndEnabledTrue(Pageable pageable, Long id, String name);

    @Modifying
    @Query("update Post p set p.name = :name, p.content = :content where p.id = :id")
    int update(@Param("id") Long id, @Param("name") String name, @Param("content") String content);

    @Modifying
    @Query("update Post p set p.enabled = false where p.id = :id")
    int remove(@Param("id") Long id);


}
