package example.exception;


import example.model.WrappedExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLTimeoutException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApplicationNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody WrappedExceptionResponse exceptionApplicationNotFound(Exception e){
        WrappedExceptionResponse resp=new WrappedExceptionResponse();
        resp.setResponse("application not found");
        return resp;
    }

    @ExceptionHandler(DuplicateApplicationException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public @ResponseBody WrappedExceptionResponse exceptionDuplicateApplication(Exception e){
        WrappedExceptionResponse resp=new WrappedExceptionResponse();
        resp.setResponse("need to deduplicate application");
        return resp;
    }

    @ExceptionHandler(SQLTimeoutException.class)
    @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
    public @ResponseBody WrappedExceptionResponse exceptionDbTimeout(){
        WrappedExceptionResponse resp=new WrappedExceptionResponse();
        resp.setResponse("database unavailable");
        return resp;
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody WrappedExceptionResponse exceptionSql(Exception e){
        WrappedExceptionResponse resp=new WrappedExceptionResponse();
        resp.setResponse(e.getCause().toString());
        return resp;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody WrappedExceptionResponse exception(Exception e){
        WrappedExceptionResponse resp=new WrappedExceptionResponse();
        resp.setResponse(e.getCause().toString());
        return resp;
    }
}