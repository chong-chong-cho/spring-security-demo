package com.ll.userlogin.controller.bean

import com.ll.userlogin.repository.DbUser
import com.ll.userlogin.service.utils.Roles
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

data class User(
    override var id: Int?,
    var userName: String,
    var passWord: String,
    override var sex: String?,
    override var address: String?,
    override var role: Roles?) :
    DbUser(id, userName, passWord, sex, address, role) {

}