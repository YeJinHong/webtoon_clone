package com.example.webtoon_api;

import com.example.webtoon_api.api.user.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Slf4j
public class JpaPjtApplicationTests {

    @Autowired
    UserRepository userRepository;

    // @BeforeEach
    // void insertTestData(){
    //     UserEntity user = new UserEntity();
    //     user.setUsername("kim ori");
    //     userRepository.save(user);
    //
    //     user = new UserEntity();
    //     user.setUsername("lee ori");
    //     userRepository.save(user);
    //
    //     user = new UserEntity();
    //     user.setUsername("kim test");
    //     userRepository.save(user);
    // }
    //
    // @Test
    // void findAllTest(){
    //     List<UserEntity> userList = userRepository.findAll();
    //     for(UserEntity user : userList)
    //         log.info("[FindAll]:"+user.getId()+"| "+user.getUsername());
    }

}
