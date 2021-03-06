package com.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.config.MyUserRepository;
import com.demo.entity.MyUser;

@RestController
@RequestMapping("/users")
public class UserController {

    private MyUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(MyUserRepository myUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = myUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping("/hello")
    public String hello(){
      return "hello";
    }
    
    @PostMapping("/post")
    public String post(@RequestBody String a){
      return a;
    }

    @PostMapping("/signup")
//    @RequestMapping(value="")
    public void signUp(@RequestBody MyUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
}