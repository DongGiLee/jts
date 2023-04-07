package com.mysite.jts.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.jts.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id // @id 어노테이션은 id 속성을 기본키로 지정한다. 이제 id 속성의값은 데이터베이스에 저장할때 동일한 값으로 저장할수 없다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 속성값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장한다,
    // strategy는 고유번호를 생성하는 옵션으로 GenerationType.INDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬때 사용한다
    private Integer id;

    @Column(length = 200) // 엔티티 속성은 테이블의 컬럼명과 일치하는데 컬럼의 세부설정을 위해 @Column 어노테이션을 사용한다.
    // 엔티티 속성은 @Column 을 사용하지않아도 테이블 컬럼으로 인식한다. 테이블 컬럼으로 인식하고 싶지 않은 경우에는 @Transient 어노테이션을 쓴다.
    private String subject;

    @Column(columnDefinition = "TEXT") //columnDefinition은 컬럼의 속성을 정의할떄 사용한다.
    private String content;

    private LocalDateTime createDate; // 엔티티에서 작성할떄는 카멜케이스이지만 실제테이블에서는 스네이크케이스로 변환된다.


    // mappedBy 는 참조 엔티티의 속성명을 의미한다. 즉 Answer 엔티티에서 Question 엔티티를 참조한 속성명 question을 mappedBy에 전달해야한다.
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // Quest 한개당 답변이 여러가지라서 답변의 속성은 List형태로 구성해야한다.
    private List<Answer> answerList;

    /**
     * 질문객체(예: question)에서 답변을 참조하려면 question.getAnswerList()를 호출하면된다.
     * */
}

/**
 * 엔티티는 Setter 메서드를 구현하지않고 사용하길 추천한다.
 * 왜냐하면 엔티티는 데이터베이스와 바로 연결되어 있기때문에 데이터를 자유롭게 변경할수있는 Setter 메서드를 허용하는것이 안전하지 않다고 판단하기 떄문이다.
 *
 * 그렇다면 Setter 메서드없이 어떤게 엔티티에 값을 저장할수 있을까?
 *
 * 엔티티를 생성할 경우에는 롬복의 @Builder 어노테이션을 통한 빌드패턴을 사용하고
 * 데이터를 변경해야할경우에는 그에 해당되는 메서드를 엔티티에 추가하여 데이터를 변경하면된다.
 */
