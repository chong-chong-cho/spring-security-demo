package com.ll.userlogin.controller.bean

import com.ll.userlogin.service.DbUser
import com.ll.userlogin.service.utils.Roles

data class User(
    override var id: Int?,
    var userName: String,
    var passWord: String,
    override var sex: String?,
    override var address: String?,
    override var role: Roles?) :
    DbUser(id, userName, passWord, sex, address, role) {

}