package com.ll.userlogin.exception

import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(value = ["com.ll.userlogin"], annotations = [Service::class] )
class GlobalException {
    @ExceptionHandler(value = [InternalAuthenticationServiceException::class])
    fun handler(e: InternalAuthenticationServiceException): String? {
        return e.message
    }
}