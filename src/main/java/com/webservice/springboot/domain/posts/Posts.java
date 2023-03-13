package com.webservice.springboot.domain.posts;

import com.webservice.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 실제 DB의 테이블과 매칭될 클래스
 * Entity 클래스
 * Entity 클래스에는 setter 메소드를 생성하지 않는다! >> 필드 값의 변경이 필요하면 명확히 목적과 의도를 나타낼 수 있는 메소드 추가
 */
@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 나타냄, 기본값으로 카멜케이스 이름을 언더스코어 네이밍으로 매칭
public class Posts extends BaseTimeEntity {
    @Id // PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long Id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder // 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
