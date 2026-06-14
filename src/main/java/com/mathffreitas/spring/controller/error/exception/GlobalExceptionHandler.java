package com.mathffreitas.spring.controller.error.exception;

import com.mathffreitas.spring.model.error.NotAvailableContentException;
import com.mathffreitas.spring.model.error.UnsupportedApiVersionException;
import com.mathffreitas.spring.model.error.dto.ErrorInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler(NotAvailableContentException.class)
    @ResponseBody ErrorInfo
    handleNotAvailableContentException(
            HttpServletRequest req,
            NotAvailableContentException ex
    ) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UnsupportedApiVersionException.class)
    @ResponseBody ErrorInfo
    handleUnsupportedApiVersionException(
            HttpServletRequest req,
            UnsupportedApiVersionException ex
    ) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getLocalizedMessage());
    }
}
