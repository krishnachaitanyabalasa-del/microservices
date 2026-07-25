package com.chaitu.quiz_service.feign;

import com.chaitu.quiz_service.model.QuestionWrapper;
import com.chaitu.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="QUESTION-SERVICE")

public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions);
    //generate
    //get/questios (questionid)

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
    //getScore

    @PostMapping("question/getScore")

    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
