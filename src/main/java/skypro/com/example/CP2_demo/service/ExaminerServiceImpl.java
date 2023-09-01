package skypro.com.example.CP2_demo.service;
import org.springframework.stereotype.Service;
import skypro.com.example.CP2_demo.dto.Question;
import skypro.com.example.CP2_demo.exceptions.ExceedingQuestionsNumber;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private  QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new ExceedingQuestionsNumber();
        }
        List<Question> questionSet = new ArrayList<>();
        Question question;
        for (int i = 0; i < amount; i++) {
            question = questionService.getRandomQuestion();
            if (questionSet.contains(question)) {
                i--;
                continue;
//                questionSet.set(i,null) ;
            }
            questionSet.add(question);
        }
        return questionSet;
    }
}
