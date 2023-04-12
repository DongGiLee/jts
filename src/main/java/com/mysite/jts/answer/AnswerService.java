package com.mysite.jts.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mysite.jts.question.Question;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String contents) {

        Answer answer = new Answer();
        answer.setContents(contents);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }


}
