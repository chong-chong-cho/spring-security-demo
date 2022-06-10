package com.ll.userlogin.filter

import org.springframework.context.annotation.Configuration
import org.springframework.security.web.context.SecurityContextPersistenceFilter
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/*
@Configuration
class JWTFilter : SecurityContextPersistenceFilter() {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        request as HttpServletRequest
        response as HttpServletResponse
        val requestURI = request.requestURI
        println(requestURI)
        val session = response.getHeader("set-cookie")
        println(session)

            chain.doFilter(request,response)

    }
}*/
