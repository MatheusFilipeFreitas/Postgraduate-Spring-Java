package com.mathffreitas.spring.controller.error;

import com.mathffreitas.spring.model.error.NotAvailableContentException;
import com.mathffreitas.spring.model.error.common.ErrorInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.LOCKED)
    @ExceptionHandler(NotAvailableContentException.class)
    @ResponseBody ErrorInfo
    handleNotAvailableContentException(
            HttpServletRequest req,
            NotAvailableContentException ex
    ) {
        return new ErrorInfo(req.getRequestURL().toString(), ex.getLocalizedMessage());
    }
}
