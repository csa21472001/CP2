package skypro.com.example.CP2_demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Вопрос уже был добавлен!")
public class RepeatingQuestionFound extends RuntimeException {
    public RepeatingQuestionFound() {
    }

    public RepeatingQuestionFound(String message) {
        super(message);
    }

    public RepeatingQuestionFound(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatingQuestionFound(Throwable cause) {
        super(cause);
    }

    public RepeatingQuestionFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
