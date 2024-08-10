package com.Scalar.BookMyShow;

import com.Scalar.BookMyShow.Controllers.UserController;
import com.Scalar.BookMyShow.dtos.SignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
	@Autowired
	private  UserController userController;

	@Override
	public void run(String... args) throws Exception {

		SignUpRequestDto requestDto=new SignUpRequestDto();
		requestDto.setEmail("Jhansiyerramsetti@gmail.com");
		requestDto.setPassword("hjaksdhfkjahj");
		userController.signUp(requestDto);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);






	}

}
