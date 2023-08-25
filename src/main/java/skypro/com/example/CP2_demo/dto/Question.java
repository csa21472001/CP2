package skypro.com.example.CP2_demo.dto;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Question qwst = (Question) o;
        return question == qwst.question &&
                Objects.equals(this.answer, qwst.answer) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Вопрос - " + this.question + " Ответ -" + this.answer;
    }
}

