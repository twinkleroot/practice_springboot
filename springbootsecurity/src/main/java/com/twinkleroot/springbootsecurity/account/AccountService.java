package com.twinkleroot.springbootsecurity.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/*
    UserDetailsService 인터페이스 구현
    스프링 부트에서 스프링 시큐리티 설정을 해주는 인터페이스(임의의 user와 password를 생성)이다.
    이걸 쓰지 않기로 할 때 보통 사용자 정보를 구현하는
    Service 계층에 Spring Security의 UserDetailsService 인터페이스를 구현한다.
    - 따로 클래스를 생성해서 인터페이스를 구현해도 된다.
*/
@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    // password encoding
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));

        return accountRepository.save(account);
    }

    // 로그인할 때 UserDetailsService의 아래 메서드가 호출된다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> byUserName = accountRepository.findByUsername(username);
        Account account = byUserName.orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(account.getUsername(), account.getPassword(), authorities());
    }

    // 이런 권한(ROLE_USER)을 가진 유저라는 걸 세팅한다.
    private Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
