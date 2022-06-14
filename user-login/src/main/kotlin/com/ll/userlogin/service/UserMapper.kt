package com.ll.userlogin.service

import com.ll.userlogin.controller.bean.User
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface UserMapper {
    @Select("select * from user where id = #{id}")
    fun queryById(id: Int) : User

    @Insert("insert into user values (#{id},#{username},#{password},#{sex},#{address})")
    fun insert(user: DbUser): Int

    @Select("select * from user")
    fun listAll(): List<User>

    @Update("update user set name=#{username},password=#{password},sex=#{sex},address=#{address} where id=#{id}")
    fun update(user: DbUser): Int

    @Delete("delete from user where id = #{id}")
    fun delete(id: Int): Int

    @Select("select * from user where username=#{username}")
    fun queryByName(username : String) : User
}