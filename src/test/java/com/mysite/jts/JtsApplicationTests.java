package com.mysite.jts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JtsApplicationTests {

	/**
	 * @Autowired
	 *
	 * 객체를 주입하기위해 사용하는 스프링 어노테이션이다.
	 * 개체를 주입하는 방식에는 @Autowired 외에 Setter 또는 생성자를 사용하는 방식이다.
	 * 순환참조 문제와 같은 이유로 @Autowired 보다는 생성자를통한 객체 주입방식이 권장된다.
	 *
	 * 하지만 테스트 코드의 경우에는 생성자를 통한객체의 주입이 불가능하므로 테스트 코드 작성시에만 @Autowired를 사용하고
	 * 실제 코드 작성시에는 생성자를 통한 객체 주입방식을 사용하자
	 * */
	@Autowired
	private QuestionRepository questionRepository;

	/**
	 * @Test
	 *
	 * testJpa 메서드가 테스트 메서드임을 나타낸다.
	 * 위 클래스를 Junit으로 실행하면 @Test 어노테이션이 붙은 메서드가 실행된다.
	 *
	 * Junit은 테스트코드를 작성하고 작성한 테스트코드를 실행하기 위해 사용하는 자바의 테스트 프레임워크이다.
	 *
	 * */
//	@Test
//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("JTS가 뭔가여?");
//		q1.setContent("JTS에 대해서 알고싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);	// 첫번쨰 질문 저장
//
//		Question q2 = new Question();
//		q2.setSubject("JPA 모델질문입니다");
//		q2.setContent("ID는 자동으로생성됨?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
//	}

	/**
	 * assertEquals(기대값, 실제값)
	 *
	 * 기대값과 실제값이 동일한지를 조사한다.
	 *
	 * 만약동일하지않다면 실패로 처리된다.
	 * */

	/**
	 * findAll() : 데이터를 조회할때 사용하는 메서드이다.
	 *
	 * findById(int) : 얘의 리턴타입은 Qeustion이 아닌 Optional임에 주의하자
	 * Optional 은 null 처리를 유연하게 처리하기 위해 사용하는 클래스로 isPresent로 null이 아닌지를 확인한후 get 으로 실제 Question 객체 값을 얻어야한다.
	 *
	 * findBySubject() : 커스텀메서드다, 사요하려면 QuestioniRepository에서 인터페이스르 변경해야한다.
	 * */
	@Test
	void testJpa() {

//		findAll()
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(6, all.size());
//
//		Question q = all.get(0);
//		assertEquals("JTS가 뭔가여?",q.getSubject());


		Optional<Question> oq = this.questionRepository.findById(1); //return 값이 Optional이다.
		if (oq.isPresent()) {	// null이 아닌지를 확인한다.
			Question q = oq.get();
			assertEquals("JTS가 뭔가여?",q.getSubject());
		}
	}

}
