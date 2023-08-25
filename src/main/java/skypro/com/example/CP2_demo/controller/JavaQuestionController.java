package skypro.com.example.CP2_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skypro.com.example.CP2_demo.dto.Question;
import skypro.com.example.CP2_demo.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService service;
    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Question addQuestion() {
        return null;
    }
    @GetMapping()
    public Collection<Question> getQuestions() {
        return null;
    }
    @GetMapping("/remove")
    Question removeQuestion(String question, String answer) {
        return null;
    }

}
