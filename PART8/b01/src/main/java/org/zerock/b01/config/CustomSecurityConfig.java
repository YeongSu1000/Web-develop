package org.zerock.b01.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Log4j2
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class CustomSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        log.info("---------configure---------");

        // [책의 기존 코드 (Spring Boot 2 / JDK 8 구버전 스타일)]
        // 책에는 'http.formLogin();'으로 단독 호출하게 되어 있었음.
        // http.formLogin();

        // [현재 수정 코드 (Spring Boot 3 / JDK 17 람다 스타일)]
        // Boot 3부터는 람다식을 필수로 요구하므로 아래와 같이 변경함.
        http.formLogin(formLogin -> {
            formLogin.loginPage("/member/login");
        });

        // [부트 3 필수 변경] 레거시 http.csrf().disable()을 람다식 스타일로 전면 교정
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        log.info("-----------web configure------------");

        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }
}
