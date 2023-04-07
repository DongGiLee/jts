package com.mysite.jts;

import com.mysite.jts.answer.Answer;
import com.mysite.jts.answer.AnswerRepository;
import com.mysite.jts.question.Question;
import com.mysite.jts.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	@Autowired
	private AnswerRepository answerRepository;

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
	 * REFR : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	 *
	 * findBy + (엔티티의 속성명)과 같은 레포지터리 메서드를 작성하면 해당속성값으로 데이터를 조회할수있다.
	 *
	 * findAll() : 데이터를 조회할때 사용하는 메서드이다.
	 *
	 * findById(int) : 얘의 리턴타입은 Qeustion이 아닌 Optional임에 주의하자
	 * Optional 은 null 처리를 유연하게 처리하기 위해 사용하는 클래스로 isPresent로 null이 아닌지를 확인한후 get 으로 실제 Question 객체 값을 얻어야한다.
	 *
	 * findBySubject() : 커스텀메서드다, 사요하려면 QuestioniRepository에서 인터페이스르 변경해야한다.
	 *
	 * */
	@Transactional
	@Test
	void testJpa() {

//		findAll()
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(6, all.size());
//
//		Question q = all.get(0);
//		assertEquals("JTS가 뭔가여?",q.getSubject());

//		findById()
//		Optional<Question> oq = this.questionRepository.findById(1); //return 값이 Optional이다.
//		if (oq.isPresent()) {	// null이 아닌지를 확인한다.
//			Question q = oq.get();
//			assertEquals("JTS가 뭔가여?",q.getSubject());

//		findBySubject()
//		List<Question> q = this.questionRepository.findBySubject("JTS가 뭔가여?");
//		for (Question qq:
//			 q) {
//			System.out.println("asdasd"+qq.getSubject());
//		}

//		findBySubjectAndContent()
//		응용 findBySubjectAndContentAndId()
//
//		List<Question> q = this.questionRepository.findBySubjectAndContentAndId("JTS가 뭔가여?","JTS에 대해서 알고싶습니다.",3);
//
//		for (Question qq:
//			 q) {
//			System.out.println("Current : "+qq.getId());
//		}

//		findBySubjectLike
//		List<Question> q = this.questionRepository.findBySubjectLike("%JPA%");
//
//		for (Question qq:
//			 q) {
//			System.out.println("Current : "+qq.getId());
//		}

//		데이터 수정하기,
//		setter 로 사용하기

//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);

//		데이터 삭제하기
//		레포지터리 객체에 count()를 사용하면 total 을 얻을수있다.
//		레포지터리 객체에 delete()를 사용하면 DELETE 문을 사용
//		
//		assertEquals(6, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(3);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(5,this.questionRepository.count());

//		답변 데이터 생성후 저장하기
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContents("네 자동으로 생성됩니당");
//		a.setQuestion(q); //어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);

//		답변 조회하기, 연결된 질문조회하기
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(1, a.getQuestion().getId());

//		답변에 연결된 질문 찾기 vs 질문에 달린 답변찾기
//		JPA 모델질문입니다
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("수정된 제목",answerList.get(0).getContents());

	}
}


