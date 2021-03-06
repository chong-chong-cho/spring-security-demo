package com.ll.userlogin.controller.handler

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Configuration
 import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
class MyAuthenticationFailHandler : AuthenticationFailureHandler{
    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        exception: AuthenticationException
    ) {
        //设置响应格式与字符集，防止乱码
        response.characterEncoding = "utf-8"
        response.contentType = "application/json"
        response.status = 500

        val objectMapper = ObjectMapper()
        //返回错误信息
        response.writer.write(objectMapper.writeValueAsString(exception.message))
    }
}