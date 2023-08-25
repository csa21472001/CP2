package skypro.com.example.CP2_demo.service;

import org.springframework.stereotype.Service;
import skypro.com.example.CP2_demo.dto.Question;

import java.util.Collection;

@Service
public class JavaQuestionService implements QuestionService {
    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question remove(String question, String answer) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion(String question, String answer) {
        return null;
    }
}
