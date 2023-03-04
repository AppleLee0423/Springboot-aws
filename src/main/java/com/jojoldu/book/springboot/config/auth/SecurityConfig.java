package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
//Spring Security 설정 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //h2-console 화면을 사용하기 위해 해당 옵션들을 disable
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                    //URL별 권한 관리를 설정
                    .authorizeHttpRequests()

                    //권한 관리 대상 지정, permitAll() 전체 열람 권한, /api/v1/**는 USER 권한이 있는 사람만 가능
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())

                    //나머지 URL, 인증된 사용자만 허용
                    .anyRequest().authenticated()

                .and()
                    // 로그아웃 기능, 로그아웃 시 이동할 주소
                    .logout()
                    .logoutSuccessUrl("/")

                .and()
                    //로그인 기능설정
                    .oauth2Login()

                    //로그인 이후 사용자 정보를 가져올 때 설정
                    .userInfoEndpoint()

                    //로그인 성공 시 진행하고자 하는 기능 설정
                    .userService(customOAuth2UserService);
    }
}
