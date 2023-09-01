package skypro.com.example.CP2_demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Превышение кол-ва вопросов")
public class ExceedingQuestionsNumber extends RuntimeException {
    public ExceedingQuestionsNumber() {
    }

    public ExceedingQuestionsNumber(String message) {
        super(message);
    }

    public ExceedingQuestionsNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceedingQuestionsNumber(Throwable cause) {
        super(cause);
    }

    public ExceedingQuestionsNumber(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
