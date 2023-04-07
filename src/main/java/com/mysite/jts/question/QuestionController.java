package com.mysite.jts.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

/**
 * @RequiredArgsConstructor : final이 붙은 속성을 포함하는 생성자를 자동으로 생성한다. 따라서 스프링 의존성 주입규칙에 의해 questionRepository 객체가 자동으로 주입된다.
 *
 * */

/**
 * 스프링의 의존성 주입(DI) 방식 3가지
 * 
 * @Autowired 속성 - 속성에 @Autowired 어노테이션을 적용하여 객체를 주입하는 방식
 * 생성자 - 생성자를 작성하여 객체를 주입하는방식 (권장 )
 * Setter - Setter 메서드를 작성하여 객체를 주입하는 방식 (메서드에 @Autowired 어노테이션이 필요하다)
 * 
 * */
@RequiredArgsConstructor
@Controller
//@ResponseBody
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList",questionList);

        return "question_list";
    }
}
