package com.capgemini;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.dataaccess.entity.UserEntity;

@SpringBootApplication
public class UserProfileRankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileRankingApplication.class, args);
	}

	@Bean
	public Map<Long, UserEntity> usersMap() {
		return new HashMap<>();
	}
}
