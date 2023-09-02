package skypro.com.example.CP2_demo.service;

import skypro.com.example.CP2_demo.dto.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
