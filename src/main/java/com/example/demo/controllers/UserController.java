package com.example.demo.controllers;

import java.util.HashMap;

import java.util.Map;

import com.example.demo.domains.UserDto;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired UserService userService;
    @PostMapping("/users")
    public Map<String, String> join(@RequestBody UserDto user){
        System.out.println("=============Join===============");
        Map<String, String> map = new HashMap<>();
        System.out.println("아이디: "+user.getUserid());
        System.out.println("비밀번호: "+user.getPassword());
        System.out.println("이름: "+user.getName());
        int result = userService.join(user);
        if(result == 1){
            map.put("name", user.getName());
        }else{
            map.put("name", "FAILURE");
        }
        return map;
    }
    @PostMapping("/users/login")
    public Map<String, String> login(@RequestBody UserDto user){
        System.out.println("==============login==============");
        Map<String, String> map =  new HashMap<>();
        UserDto result = userService.login(user);
        if(result != null){
            map.put("name", result.getName());
        }else{
            map.put("name","FAILURE");
        }
       
        return map;
    }
}