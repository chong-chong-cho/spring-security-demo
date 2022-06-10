package com.ll.userlogin.config

import com.ll.userlogin.handler.MyAuthenticationFailHandler
import com.ll.userlogin.handler.MyAuthenticationSuccessHandler
import com.ll.userlogin.handler.MyLogoutSuccessUrl
import com.ll.userlogin.utils.Roles
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class MyWebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()//跨域处理
            .formLogin()//自定义表单登录
            .loginPage("http://localhost:4200/login")//指定自定义登录界面
            .loginProcessingUrl("/user/login")//指定校验路径
            .successHandler(MyAuthenticationSuccessHandler())//成功或失败后重定向的页面结果
            .failureHandler(MyAuthenticationFailHandler())
            .and()
            .authorizeRequests()
            .antMatchers("/user/query/{id}").hasAuthority(Roles.ROLE_MANAGER.toString())//用户授权
            .antMatchers("/user/login","http://localhost:4200/login").permitAll()//放行登录请求
            .anyRequest().authenticated()
            .and()
            .logout()
            .logoutUrl("/user/logout")
            .logoutSuccessHandler(MyLogoutSuccessUrl())
    }

    /**
     * 注入一个PasswordEncoder
     */
    @Bean
    fun getPassWordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder(10)
    }
}