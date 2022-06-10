package com.ll.userlogin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
@EnableWebSecurity
class UserLoginApplication

fun main(args: Array<String>) {
    runApplication<UserLoginApplication>(*args)
}


