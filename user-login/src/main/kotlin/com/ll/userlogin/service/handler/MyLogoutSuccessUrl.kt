package com.ll.userlogin.service.handler

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MyLogoutSuccessUrl : LogoutSuccessHandler {
    override fun onLogoutSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        authentication: Authentication?
    ) {
        response.sendRedirect("/user/login")
    }
}