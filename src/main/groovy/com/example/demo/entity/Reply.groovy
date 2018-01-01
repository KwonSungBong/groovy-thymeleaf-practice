package com.example.demo.entity

import lombok.Data
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType
import javax.validation.constraints.Size

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

    @Size(min=1, max=255)
    String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    Post post

    @Column(nullable = false)
    boolean enabled = true;

    @CreatedBy
    @OneToOne
    User createdUser

    @LastModifiedBy
    @OneToOne
    User lastModifiedUser

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    Date createdDate

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    Date lastModifiedDate

}
