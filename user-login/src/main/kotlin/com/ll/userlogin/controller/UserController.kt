package com.ll.userlogin.controller

import com.ll.userlogin.bean.User
import com.ll.userlogin.service.UserService
import com.ll.userlogin.utils.R
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins=["*"],maxAge=3600)
@Api(value = "测试", description = "测试控制器")
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/query/{id}")
    @ApiOperation("登录", notes = "用户信息")
    fun login(@PathVariable id : Int) : User {
        return userService.queryById(id)
    }

    @PostMapping("/register")
    @ApiOperation("注册", notes = "用户信息注册")
    fun register(@RequestBody user : User) : String{
        return userService.register(user)
    }

    @GetMapping("/list")
    @ApiOperation("查询所有", notes = "展示所有用户信息")
    fun listAll() : List<User>{
        return userService.listAll()
    }

    @PutMapping("/update")
    @ApiOperation("修改", notes = "修改用户信息")
    fun update(@RequestBody user: User) : String{
        return userService.update(user)
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除", notes = "删除用户信息")
    fun delete(@PathVariable id : Int) : String{
        return userService.delete(id)
    }
}