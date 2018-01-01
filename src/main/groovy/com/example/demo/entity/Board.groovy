package com.example.demo.entity

import lombok.Data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

import static javax.persistence.GenerationType.AUTO

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Data
@Entity
class Board {

    @Id
    @GeneratedValue(strategy = AUTO)
    Long id

    String name

    @OneToMany(mappedBy = "board")
    List<Post> postList

}
