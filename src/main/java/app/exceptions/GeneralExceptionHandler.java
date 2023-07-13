package app.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main exception handler for http requests
 */
@Log4j2
@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(BadRequestException.class)
  @MessageExceptionHandler(BadRequestException.class)
  public ErrorInfo handleBadRequestException(RuntimeException ex, HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    return new ErrorInfo(UrlUtils.buildFullRequestUrl(request), ex.getMessage());
  }


}

