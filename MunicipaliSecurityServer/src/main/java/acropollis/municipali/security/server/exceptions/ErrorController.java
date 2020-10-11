package acropollis.municipali.security.server.exceptions;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void handleHttpMessageNotReadableException(HttpServletResponse response, Exception e) throws Exception {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().println(e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public void handleEntityNotFound(HttpServletResponse response, Exception e) throws Exception {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        response.getWriter().println(e.getMessage());
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public void handleEntityAlreadyExists(HttpServletResponse response, Exception e) throws Exception {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().println(e.getMessage());
    }

    @ExceptionHandler(ForbiddenException.class)
    public void handleCredentialsViolation(HttpServletResponse response, Exception e) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().println(e.getMessage());
    }
}