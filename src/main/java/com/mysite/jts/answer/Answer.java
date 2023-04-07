package com.mysite.jts.answer;

import com.mysite.jts.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @Entity
public class Answer {
    /**
     * answer.getQuestion().getSubject() 처럼 접근할수 있다. 다만이렇게 사용하려면
     * ManyToOne 어노테이션을 추가해줘야한다.
     *
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String contents;

    private LocalDateTime createDate;

    @ManyToOne  // N:1 관계, 부모는 Question, 자식은 Answer
    private Question question;
}
