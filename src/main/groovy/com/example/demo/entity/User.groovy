package com.example.demo.entity

import javax.persistence.Column
import javax.persistence.Enumerated

import static javax.persistence.EnumType.STRING
import static javax.persistence.GenerationType.AUTO

import lombok.Data
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Data
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

}
