package com.example.jpa_api.testcase.user;

import com.example.jpa_api.core.PasswordEncodeUtils;
import com.example.jpa_api.jpa.entity.Role;
import com.example.jpa_api.jpa.entity.Users;
import com.example.jpa_api.jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@Slf4j
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void selectUser() throws Exception {
		Users users = new Users("whydda", PasswordEncodeUtils.encodePassword("password"), "변진환", Role.ROLE_USER, LocalDateTime.now());
		this.entityManager.persist(users);

		Users users2 = userRepository.findById("whydda").orElse(null);
		System.out.println(users2.toString());
	}

	@Test
	public void findUserShouldReturnNull() throws Exception {

	}
}
