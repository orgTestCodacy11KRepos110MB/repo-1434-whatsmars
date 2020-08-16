package org.hongxi.whatsmars.boot.sample.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.hongxi.whatsmars.boot.sample.web.model.JsonResponse;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by shenhongxi on 2020/8/16.
 */
@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public JsonResponse handleLogicException(HttpServletRequest request, BusinessException e) {
        log.error("business exception handled, request:{}", request.getRequestURI(), e);
        return JsonResponse.error(e.getCode(), e.getMsg());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResponse handleException(HttpServletRequest request, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        log.error("exception handled, request:{}", request.getRequestURI(), e);
        return JsonResponse.error(500, e.getMessage());
    }
}
