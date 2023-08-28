package skypro.com.example.CP2_demo.service;

import org.junit.jupiter.api.Test;
import skypro.com.example.CP2_demo.dto.Question;
import skypro.com.example.CP2_demo.exceptions.QuestionNotFound;
import skypro.com.example.CP2_demo.exceptions.RepeatingQuestionFound;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService underTest = new JavaQuestionService();

//    @ParameterizedTest
//    @MethodSource("dataForDivide")
//    void divide__returnFloat(int num1, int num2, double expectedResult) {
//        var result = underTest.divide(num1, num2);
//        assertEquals(expectedResult, result);
//    }
//    private static Stream<Arguments> dataForDivide() {
//        return Stream.of(
//                Arguments.of(4, 2, 2),
//                Arguments.of(5, 2, 2.5)
//        );
//    }
Question question = new Question("Как дела?", "Отлично.");
//    public Map<Integer, Question> questionMap = new HashMap<>();
//    questionMap.put(1,question);

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
        assertEquals(null,ex.getMessage());
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