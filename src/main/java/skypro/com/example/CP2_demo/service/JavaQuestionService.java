package skypro.com.example.CP2_demo.service;

import org.springframework.stereotype.Service;
import skypro.com.example.CP2_demo.dto.Question;
import skypro.com.example.CP2_demo.exceptions.QuestionNotFound;
import skypro.com.example.CP2_demo.exceptions.RepeatingQuestionFound;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Map <Integer,Question> questions;
    private int counter = 0 ;

    public JavaQuestionService() {
        this.questions = new HashMap<>();;
    }

    @Override
    public Question add(String question, String answer) {
        Question questionToMap = new Question(question, answer);

        if (questions.containsValue(questionToMap)) {
            throw new RepeatingQuestionFound();
        }

        questions.put(counter, questionToMap);
        counter++;
        return questionToMap;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.containsValue(question)) {
            throw new QuestionNotFound();
        } else {
            removeByValue(questions, question);
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.values();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }


    public <Integer, Question> void removeByValue(Map<Integer, Question> map, Question value) {
        Set<Integer> keysToRemove = new HashSet<>();

        for (Map.Entry<Integer, Question> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keysToRemove.add(entry.getKey());
            }
        }

        for (Integer key : keysToRemove) {
            map.remove(key);
        }
    }

}
