package com.ll.userlogin.service

import com.ll.userlogin.controller.bean.User
import com.ll.userlogin.repository.UserMapper
import com.ll.userlogin.service.utils.Roles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
@Service
class UserServiceImpl : UserService, UserDetailsService {

    @Autowired
    private lateinit var mapper : UserMapper

    /**
     * 注入密码加密器
     * */
    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    /**
     * 登录方法
     * */
    override fun queryById(id : Int): User {
        return mapper.queryById(id)
    }

    /**
     * 注册方法
     * */
    override fun register(user: User): String {
        val insert : Int = mapper.insert(user)
        return if (insert > 0){
            "success"
        }else{
            "fail"
        }
    }

    /**
     * 展示所有用户
     * */
    override fun listAll(): List<User> {
        return mapper.listAll()
    }

    /**
     * 修改方法
     **/
    override fun update(user: User): String {
        val update : Int = mapper.update(user)
        return if (update > 0){
            "success"
        }else{
            "fail"
        }
    }

    /**
     * 删除方法
     * */
    override fun delete(id: Int) : String {
        val delete : Int = mapper.delete(id)
        return if (delete > 0) {
            "success"
        } else {
            "fail"
        }
    }

    /**
     * 登录时的用户密码校验
     */
    override fun loadUserByUsername(username: String): UserDetails {
        val user = mapper.queryByName(username) ?: throw RuntimeException("用户名或密码错误")
        //判断用户身份，限制用户登录
        var password = ""
        if (Roles.ROLE_MANAGER == user.role || Roles.ROLE_USER == user.role){
            //采用BCryptPasswordEncoder方式加密密码进行比较
            password = passwordEncoder.encode(user.passWord)
        }
        //返回用户
        return org.springframework.security.core.userdetails.User(
            user.userName,
            password,
            AuthorityUtils.commaSeparatedStringToAuthorityList(user.role.toString())
        )
    }
}

