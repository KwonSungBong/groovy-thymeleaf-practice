package com.example.demo.entity

import lombok.Data
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.*

import static javax.persistence.EnumType.STRING
import static javax.persistence.GenerationType.AUTO

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id

    @Column(unique = true, nullable = false)
    String username

    @Column(nullable = false)
    String password

    @Column(nullable = true)
    String email

    @Column(nullable = false)
    @Enumerated(STRING)
    Role role

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
