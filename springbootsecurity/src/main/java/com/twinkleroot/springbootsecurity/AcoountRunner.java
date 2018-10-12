package com.twinkleroot.springbootsecurity;

import com.twinkleroot.springbootsecurity.account.Account;
import com.twinkleroot.springbootsecurity.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AcoountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account jungmo = accountService.createAccount("jungmo", "qwer");
        System.out.println(jungmo.getUsername() + " password: " + jungmo.getPassword());
    }

}
