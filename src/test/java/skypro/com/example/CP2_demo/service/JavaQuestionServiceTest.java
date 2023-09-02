package skypro.com.example.CP2_demo.service;

import org.junit.jupiter.api.Test;
import skypro.com.example.CP2_demo.dto.Question;
import skypro.com.example.CP2_demo.exceptions.QuestionNotFound;
import skypro.com.example.CP2_demo.exceptions.RepeatingQuestionFound;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService underTest = new JavaQuestionService();

Question question = new Question("Как дела?", "Отлично.");

    @Test
    void addQuestiom_newQuestion_questionAdded() {
        Question result = underTest.add(question.getQuestion(), question.getAnswer());
        assertEquals(question, result);
        assertTrue(underTest.getAll().contains(question));
    }
    @Test
    void addQuestion_questionHasBeenAdded_thrownException() {
        underTest.add(question.getQuestion(), question.getAnswer());
        RepeatingQuestionFound ex = assertThrows(RepeatingQuestionFound.class,
                () -> underTest.add(question.getQuestion(), question.getAnswer()));
        assertNull(ex.getMessage());
    }
    @Test
    void removeQuestion_questionIsInTheMap_questionRemovedAndReturned() {
        underTest.add(question.getQuestion(), question.getAnswer());
        Question result = underTest.remove(question);
        assertEquals(question,result);
        assertFalse(underTest.getAll().contains(question));
    }
    @Test
    void removeQuestion_questionIsNotInTheMap_thrownException() {
        assertThrows(QuestionNotFound.class, () -> underTest.remove(question));
    }

    @Test
    void getAllQuestions_emptyList_returnEmptyCollection() {
        Collection<Question> result = underTest.getAll();
        assertIterableEquals(Collections.emptyList(), result);
    }

    @Test
    void getAllQuestions_thereAreQuestions_returnEmptyCollection() {
        underTest.add(question.getQuestion(), question.getAnswer());
        Collection<Question> result = underTest.getAll();
        assertIterableEquals(List.of(question), result);
    }



}