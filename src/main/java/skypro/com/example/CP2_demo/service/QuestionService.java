package skypro.com.example.CP2_demo.service;

import skypro.com.example.CP2_demo.dto.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
    int getCounter();
}
