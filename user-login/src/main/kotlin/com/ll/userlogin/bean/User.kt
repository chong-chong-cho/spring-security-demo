package com.ll.userlogin.bean

import com.ll.userlogin.utils.Roles
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

data class User(
    var id : Int?,
    var userName : String,
    var passWord : String,
    var sex : String?,
    var address : String?,
    var role : Roles?
)