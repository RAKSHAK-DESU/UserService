package com.warrom.UserService.controller;

import com.warrom.UserService.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> ul = new ArrayList<>();
    public UserController(){

        ul.add(new User(1,"Justin","Toronto"));
        ul.add(new User(2,"Dan","LA"));
        ul.add(new User(3,"Rakshak","Yokohama"));
        ul.add(new User(4,"Andrew","Dubai"));
        ul.add(new User(5,"David","Bangkok"));
    }


    @RequestMapping("/greet")
    public String greet(){
        return "Hello There!!";
    }

    @RequestMapping("/users")
    public List<User> getUsers(){
        return ul;
    }



    @RequestMapping("/user")
    public User getUserById(@RequestParam int uid){
        return ul.stream()
                .filter(u->u.getUid()==uid)
                .findFirst()
                .orElseThrow(()->
                        new RuntimeException("User not found with ID"+uid));
    }

    @RequestMapping("/username/{uname}")
    public User getUserByName(@PathVariable String uname){
        return  ul.stream()
                .filter(u-> u.getUname().equals(uname))
                .findFirst()
                .orElseThrow(()->
                        new RuntimeException("User not found wiit Name"+uname));
    }




}