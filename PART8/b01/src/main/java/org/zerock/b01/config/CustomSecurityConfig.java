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
        // 아직 커스텀 로그인 페이지가 없으므로 내부 설정은 비워두어 스프링 기본 로그인창을 쓰도록 유도.
        http.formLogin(formLogin -> {

        });

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        log.info("-----------web configure------------");

        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }
}
