package com.example.demo.entity

import lombok.Data
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType

import static javax.persistence.GenerationType.AUTO

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
class Post {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id

    String name;

    String content

    @ManyToOne
    @JoinColumn(name="board_id")
    Board board

    @OneToMany(mappedBy = "post")
    List<Reply> replyList

    @CreatedBy
    @OneToOne
    User createdUser

    @LastModifiedBy
    @OneToOne
    User lastModifiedBy

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    Date createdDate

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    Date lastModifiedDate

}
