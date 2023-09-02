package skypro.com.example.CP2_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.com.example.CP2_demo.dto.Question;
import skypro.com.example.CP2_demo.service.JavaQuestionService;
import skypro.com.example.CP2_demo.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService service;
    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,@RequestParam String answer) {
        return service.add(question,answer);
    }
    @GetMapping()
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,@RequestParam String answer) {
        Question questionToRemove = new Question(question, answer);
        return service.remove(questionToRemove);
    }

}
