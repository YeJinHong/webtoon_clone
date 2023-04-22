package com.example.webtoon_api.repository;

import com.example.webtoon_api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findFirst2ByUsernameLikeOrderByIdDesc(String name);
}
