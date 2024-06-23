package projeto.pic.com.picpay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import projeto.pic.com.picpay.exception.PicPayException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PicPayException.class)
    public ProblemDetail handlePicPayException(PicPayException e){
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        var fieldErros = e.getFieldErrors()
        .stream()
        .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
        .toList();
                            
        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle("Your Request paramters didn't validate.");
        pd.setProperty("Invalid-params", fieldErros);
        return pd;
    }

    private record InvalidParam(String name, String reason){};

}
