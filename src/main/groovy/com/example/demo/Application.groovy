package com.example.demo

import com.example.demo.entity.Role
import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
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
	UserRepository userRepository

	@Bean
	@Transactional
	InitializingBean localInitializingBean() {
		return {
			User findUser = userRepository.findByUsername("test")

			if(findUser == null) {
				User user = new User()
				user.username = "test"
				user.password = new BCryptPasswordEncoder().encode("test")
				user.role = Role.USER
				user.email = "test@test.com"
				userRepository.save(user)
			}

		}
	}

}
