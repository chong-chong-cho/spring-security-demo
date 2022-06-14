package com.ll.userlogin.controller.config

import com.ll.userlogin.controller.handler.MyAuthenticationFailHandler
import com.ll.userlogin.controller.handler.MyAuthenticationSuccessHandler
import com.ll.userlogin.controller.handler.MyLogoutSuccessUrl
import com.ll.userlogin.service.utils.Roles
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class MyWebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .formLogin()
            .loginPage("http://localhost:4200/login")
            .loginProcessingUrl("/user/login")
            .successHandler(MyAuthenticationSuccessHandler())
            .failureHandler(MyAuthenticationFailHandler())
            .and()
            .authorizeRequests()
            .antMatchers("/user/query/{id}").hasAuthority(Roles.ROLE_MANAGER.toString())
            .antMatchers("/user/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .logout()
            .logoutUrl("/user/logout")
    }

    /**
     * 注入一个PasswordEncoder
     */
    @Bean
    fun getPassWordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder(10)
    }
}