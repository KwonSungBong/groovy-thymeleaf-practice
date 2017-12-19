package com.example.demo.entity

import lombok.Data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import static javax.persistence.GenerationType.AUTO

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Data
@Entity
class Reply {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id

}
