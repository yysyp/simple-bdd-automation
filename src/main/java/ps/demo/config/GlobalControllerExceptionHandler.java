package ps.demo.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleThrowable(Exception e) {
        log.error("Exception handleThrowable, message={}", e.getMessage(), e);

        return new ResponseEntity(e.getMessage(), HttpStatus.OK);
    }

}