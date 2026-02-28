package com.greetlabs.School_Application.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception exception,HttpServletRequest request){
        String requestURI = request.getRequestURI();

        if (exception instanceof org.apache.catalina.connector.ClientAbortException) {
            return null;
        }
        log.error("Exception occurred: ", exception);
        ModelAndView errorpage = new ModelAndView();
        errorpage.setViewName("error");
        errorpage.addObject("errormsg", exception.getMessage());
        return errorpage;
    }
}
