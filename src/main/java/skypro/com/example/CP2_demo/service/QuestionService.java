package skypro.com.example.CP2_demo.service;

import skypro.com.example.CP2_demo.dto.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
