package com.mysite.jts.question;

import com.mysite.jts.answer.AnswerForm;
import com.mysite.jts.answer.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
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
@RequestMapping("question")
@RequiredArgsConstructor
@Controller
//@ResponseBody
public class QuestionController {

//    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    private final AnswerService answerService;

    @GetMapping("/list")
    public String list(Model model) {
//        List<Question> questionList = this.questionRepository.findAll();
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList",questionList);

        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);

        model.addAttribute("question",question);

        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    /**
     * BindingResult 매개변수는 항상 @Valid 매개변수 바로뒤에 위치해야한다.
     * 만약 2개의 매개변수의 위치가 정확하지않다면 @Valid만 적용이 되어 입력값 검증 실패 시 400 오류가 발생한다.
     *
     * */
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
