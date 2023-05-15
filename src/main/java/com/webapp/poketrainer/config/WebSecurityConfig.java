package com.webapp.poketrainer.config;


import com.webapp.poketrainer.model.enums.UserRole;
import com.webapp.poketrainer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final String[] staticResources = {
            "/css/**",
            "/images/**",
            "/register",
            "/about",
            "/contact",
            "/",
            "/error",
            "/dashboard",
            "/admin",
            "/**"

    };

    private final String[] dashboardResources = {
            //"/dashboard",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(
                        auth -> {
                            auth.requestMatchers(staticResources).permitAll();
                            auth.requestMatchers(dashboardResources)
                                    .hasAnyAuthority(
                                            UserRole.USER.name(),
                                            UserRole.ADMIN.name());
                        })
                .formLogin(
                        (form) ->
                                form
                                        .loginPage("/login")
                                        .loginProcessingUrl("/login")
                                        .defaultSuccessUrl("/")
                                        .permitAll())
                .httpBasic();

        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

}
