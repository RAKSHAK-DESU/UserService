package com.warrom.UserService.controller;


import com.warrom.UserService.model.User;
import org.springframework.web.bind.annotation.*;

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



    @RequestMapping("/user/{uid}")
    public User getUserById(@RequestParam int uid){
        return ul.stream()
                .filter(u->u.getUid()==uid)
                .findFirst()
                .orElseThrow(()->
                        new RuntimeException("User not found with ID"+uid));
    }  //get mapping

    @RequestMapping("/username/{uname}")
    public User getUserByName(@PathVariable String uname){
        return  ul.stream()
                .filter(u-> u.getUname().equals(uname))
                .findFirst()
                .orElseThrow(()->
                        new RuntimeException("User not found wiit Name"+uname));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User insertUser(@RequestBody User usr){
        ul.add(usr);
        return  ul.stream()
                .filter(u-> u.getUid()== usr.getUid())
                .findFirst()
                .orElseThrow(()->
                        new RuntimeException("Unable to Save User"));
    }

    @RequestMapping(value = "/update/{uid}", method =RequestMethod.PUT)
    public User updateUser(@PathVariable int uid,@RequestBody User usr) {
        User existing = ul.stream()
                .filter(u -> u.getUid() == uid)
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("User not found with ID" + uid));

        if (usr.getUname()!=null)
            existing.setUname(usr.getUname());
        if (usr.getAddr()!=null)
            existing.setAddr(usr.getAddr());

        return existing;

    }

    @RequestMapping(value = "/delete/{uid}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int uid){
        User existing = ul.stream()
                .filter(u -> u.getUid() == uid)
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("User not found with ID" + uid));

        ul.remove(existing);

        return  "User Deleted with ID::"+uid;
    }

}