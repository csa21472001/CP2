package skypro.com.example.CP2_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.com.example.CP2_demo.dto.Question;
import skypro.com.example.CP2_demo.service.ExaminerService;
import skypro.com.example.CP2_demo.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
public class ExamController {
    public final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/exam")
    public Collection<Question> getQuestions(@RequestParam int amount) {

        return service.getQuestions(amount);
    }

}
