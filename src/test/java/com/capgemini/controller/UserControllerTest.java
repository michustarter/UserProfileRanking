package com.capgemini.controller;

import com.capgemini.dataaccess.entity.UserEntity;
import com.capgemini.service.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.HashSet;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate client;

    @Test
    public void shouldReturnUser() throws Exception {
        // given
        UserDTO userDto1 = createUserDto();
        client.postForEntity("/users", userDto1, UserDTO.class);

        // when
        ResponseEntity<UserDTO> response = client.getForEntity("/users/1", UserDTO.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(userDto1);
    }

    private UserDTO createUserDto() {
        return new UserDTO(1L, "Krzysztof", "Zieliński", "krzysiek@onet.pl", "ytrdx2", "Jestem zwyciezca!",
                new HashSet<>(), Instant.now(), Instant.now(), "");
    }
}


