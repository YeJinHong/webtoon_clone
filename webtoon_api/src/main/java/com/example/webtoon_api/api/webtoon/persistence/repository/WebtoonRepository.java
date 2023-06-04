package com.example.webtoon_api.api.webtoon.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebtoonRepository extends JpaRepository<WebtoonRepository, Long> {

}
