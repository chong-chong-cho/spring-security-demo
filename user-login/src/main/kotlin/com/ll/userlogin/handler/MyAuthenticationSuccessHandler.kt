package com.ll.userlogin.handler

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MyAuthenticationSuccessHandler() : AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        //用户身份校验成功之后返回成功信息
        val objectMapper = ObjectMapper()
        response.writer.write(objectMapper.writeValueAsString(authentication))
    }
}