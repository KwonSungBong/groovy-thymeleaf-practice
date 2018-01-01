package com.example.demo.service.impl

import com.example.demo.entity.Board
import com.example.demo.repository.BoardRepository
import com.example.demo.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by ksb on 2017. 12. 30..
 */
@Service
class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository

    @Override
    List<Board> getAll() {
        boardRepository.findAll()
    }

}
