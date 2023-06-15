package com.example.webtoon_api.api.webtoon.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "webtoon")
public class WebtoonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;


    @Column(name = "author_id", nullable = false, length = 20)
    private String authorId;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    // TODO : 요일 데이터 매핑 관계 고민
//    @Column(name = "title", nullable = false)
//    private List<Integer> weekdayList;

    @Column(name = "producer_id", nullable = false, length = 20)
    private String producerId;

    @Builder
    public WebtoonEntity(Long id, String title, String authorId, String description, String producerId){
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.description = description;
        this.producerId = producerId;
    }


}
