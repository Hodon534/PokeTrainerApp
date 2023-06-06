package com.webapp.poketrainer.config;

import com.webapp.poketrainer.model.constants.AccessConst;
import com.webapp.poketrainer.model.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(
                        auth -> {
                            auth.requestMatchers(AccessConst.RESOURCES_PUBLIC).
                                    permitAll();
                            auth.requestMatchers(AccessConst.RESOURCES_USER)
                                    .hasAnyAuthority(
                                            UserRole.USER.name(),
                                            UserRole.ADMIN.name());
                            auth.requestMatchers(AccessConst.RESOURCES_ADMIN)
                                    .hasAnyAuthority(
                                            UserRole.ADMIN.name());
                        })
                .formLogin(
                        (form) ->
                                form
                                        .loginPage("/login")
                                        .loginProcessingUrl("/login")
                                        .defaultSuccessUrl("/")
                                        .permitAll())
                .httpBasic()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

        return http.build();
    }
}
