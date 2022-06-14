package com.ll.userlogin.service

import com.ll.userlogin.service.utils.Roles

open class DbUser(
    open var id : Int?,
    open var username : String,
    open var password : String,
    open var sex : String?,
    open var address : String?,
    open var role : Roles?
        )