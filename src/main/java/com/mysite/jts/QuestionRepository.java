package com.mysite.jts;

/***
 * Repository
 *
 * 엔티티에 의해 생성된 데이터베이스 테이블에 접근하는 메서드들 (Ex_ findAll, save 등)을 사용하기 위한 인터페이스이다.
 * 데이터 처리를 위해서는 테이블에 어떤 값을 넣거나 값을 조회하는등 CRUD가 필요하다
 * 이때 이러한 CRUD를 어떻게 처리할지 정의하는 계층이 바로 레포지터리다.
 */

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속할때는 제네릭스타입으로 <Question, Integer> 처럼
// 레포지터리 대상이 되는 엔티티의 타입 (Question)과 해당 엔티티의 PK의 속성타입(Integer)를 지정해야한다.
// 이것은 JpaRepository를 생성하기위한 규칙이다.

public interface QuestionRepository extends JpaRepository<Question, Integer> {


}
