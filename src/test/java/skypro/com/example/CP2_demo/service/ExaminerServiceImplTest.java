package skypro.com.example.CP2_demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.com.example.CP2_demo.dto.Question;
import skypro.com.example.CP2_demo.exceptions.ExceedingQuestionsNumber;

import java.util.Collection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService service;

    @InjectMocks
    ExaminerServiceImpl underTest;
    Question qwst1 = new Question("Как дела?", "Отлично.");
    Question qwst2 = new Question("Как дела?", "Не родила.");
    Question qwst3 = new Question("Как дела?", "Вашими молитвами.");
    Question qwst4 = new Question("Как дела?", "Мы знакомы?");
    Question qwst5 = new Question("Как дела?", "Дела у прокурора.");

    @Mock
    Collection<Question> questions;

    @BeforeEach
    void beforeEach() {
        questions = List.of(qwst1, qwst2, qwst3, qwst4, qwst5);
    }
    @Test
    void getQuestions_gettingAllQuestions_returnAllQuestions() {
        when(service.getAll()).thenReturn(questions);
        when(service.getRandomQuestion()).thenReturn(qwst1, qwst2, qwst3, qwst4, qwst5);
        Collection<Question> result = underTest.getQuestions(5);
        assertEquals(questions, result);
    }
    @Test
    void getQuestions_employeeNotFound_returnThrowException() {
    int numberOfQuestions = 6;
    assertThrows(ExceedingQuestionsNumber.class,
            () -> underTest.getQuestions(numberOfQuestions));
}

}