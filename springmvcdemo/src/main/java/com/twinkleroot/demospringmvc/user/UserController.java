package com.twinkleroot.demospringmvc.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    // HttpMessageConverters 는 @RequestBody, @ResponseBody 와 함께 사용한다.
    // 요청 본문을 객체로 변환 or 객체를 HTTP 응답 본문으로 변경할 때 사용한다.
    // @RestController를 붙여 놓으면 반환 타입에 @ResponseBody를 생략해도 된다.
    // @Controller를 사용한 경우 리턴값의 String 값으로 뷰를 찾으려고 할 것이다.

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        return user;
    }
}
