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
class Reply {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id

    String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post

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
