package com.example.webtoon_api;

import com.example.webtoon_api.entity.User;
import com.example.webtoon_api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@Slf4j
public class JpaPjtApplicationTests {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void insertTestData(){
        User user = new User();
        user.setUsername("kim ori");
        userRepository.save(user);

        user = new User();
        user.setUsername("lee ori");
        userRepository.save(user);

        user = new User();
        user.setUsername("kim test");
        userRepository.save(user);
    }

    @Test
    void findAllTest(){
        List<User> userList = userRepository.findAll();
        for(User user : userList)
            log.info("[FindAll]:"+user.getId()+"| "+user.getUsername());
    }

}
