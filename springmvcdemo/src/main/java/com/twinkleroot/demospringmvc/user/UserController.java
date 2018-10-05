package com.twinkleroot.demospringmvc.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController를 붙여 놓으면 반환 타입에 @ResponseBody를 생략해도 된다.
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {

    }
}
