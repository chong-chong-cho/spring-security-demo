package com.ll.userlogin.service.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.ll.userlogin.controller.bean.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.Calendar

class TokenUtils {

    /**
     * 生成token
     * */
    fun getToken(user: User): String {
        var calendar = Calendar.getInstance()
        calendar.add(Calendar.SECOND, 120)
        val signatureAlgorithm = SignatureAlgorithm.HS256
        val mapper = ObjectMapper()
        val json = mapper.writeValueAsString(user)
        val map = mutableMapOf<String, Any>("userInfo" to json)

        val key = "generalKey"

        val builder = Jwts.builder()
            .setClaims(map)
            .setIssuedAt(calendar.time)
            .signWith(signatureAlgorithm, key)
        return builder.compact()
    }

    /**
     * 解析token
     */
    fun parseToken(jwt: String): Claims {
        val key = "generalKey"
        return Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(jwt)
            .body
    }

}