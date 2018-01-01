package com.example.demo

import com.example.demo.entity.Board
import com.example.demo.entity.Post
import com.example.demo.entity.Reply
import com.example.demo.entity.Role
import com.example.demo.entity.User
import com.example.demo.repository.BoardRepository
import com.example.demo.repository.PostRepository
import com.example.demo.repository.ReplyRepository
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import javax.transaction.Transactional

@SpringBootApplication
class Application {

	static void main(String[] args) {
		SpringApplication.run Application, args
	}

	@Autowired
	BCryptPasswordEncoder passwordEncoder

	@Autowired
	UserService userServiceImpl

	@Autowired
	BoardRepository boardRepository

	@Autowired
	PostRepository postRepository

	@Autowired
	ReplyRepository replyRepository

	@Bean
	@Transactional
	InitializingBean localInitializingBean() {
		return {
			User findUser = userServiceImpl.getByUsername("test")

			if(findUser == null) {
				User user = new User()
				user.username = "test"
				user.password = passwordEncoder.encode("test")
				user.role = Role.ROLE_USER
				user.email = "test@test.com"
				userServiceImpl.save(user)
			}

			List<Board> findBoardList = boardRepository.findAll()

			if(findBoardList.size() == 0) {
				Board board1 = new Board()
				Board board2 = new Board()
				Board board3 = new Board()

				board1.setName("board1")
				board2.setName("board2")
				board3.setName("board3")

				boardRepository.save(board1)
				boardRepository.save(board2)
				boardRepository.save(board3)

				Post post1 = new Post()
				Post post2 = new Post()
				Post post3 = new Post()
				Post post4 = new Post()
				Post post5 = new Post()
				Post post6 = new Post()
				Post post7 = new Post()
				Post post8 = new Post()
				Post post9 = new Post()

				post1.setName("postSubject1")
				post2.setName("postSubject2")
				post3.setName("postSubject3")
				post4.setName("postSubject4")
				post5.setName("postSubject5")
				post6.setName("postSubject6")
				post7.setName("postSubject7")
				post8.setName("postSubject8")
				post9.setName("postSubject9")

				post1.setContent("postContent1")
				post2.setContent("postContent2")
				post3.setContent("postContent3")
				post4.setContent("postContent4")
				post5.setContent("postContent5")
				post6.setContent("postContent6")
				post7.setContent("postContent7")
				post8.setContent("postContent8")
				post9.setContent("postContent9")

				post1.setBoard(board1)
				post2.setBoard(board1)
				post3.setBoard(board1)
				post4.setBoard(board1)
				post5.setBoard(board1)
				post6.setBoard(board1)
				post7.setBoard(board1)
				post8.setBoard(board1)
				post9.setBoard(board1)

				postRepository.save(post1)
				postRepository.save(post2)
				postRepository.save(post3)
				postRepository.save(post4)
				postRepository.save(post5)
				postRepository.save(post6)
				postRepository.save(post7)
				postRepository.save(post8)
				postRepository.save(post9)

				Reply reply1 = new Reply()
				reply1.setContent("reply1")
				reply1.setPost(post9)
				replyRepository.save(reply1)
			}

		}
	}

}
