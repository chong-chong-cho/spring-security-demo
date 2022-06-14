package com.ll.userlogin.service

import com.ll.userlogin.controller.bean.User

interface UserService {
    /**
     * 用户登录
     */
    fun queryById(id: Int): User

    /**
     * 用户注册
     */
    fun register(user: User): String

    /**
     * 展示所有用户信息
     */
    fun listAll(): List<User>

    /**
     * 修改指定用户信息
     */
    fun update(user: User): String

    /**
     * 删除指定用户信息
     */
    fun delete(id: Int) : String
}