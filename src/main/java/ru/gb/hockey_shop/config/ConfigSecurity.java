package ru.gb.hockey_shop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ru.gb.hockey_shop.model.Person;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfigSecurity {

    @Bean
    public UserDetailsService userDetailsService (PasswordEncoder encoder){
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN", "USER").build();

        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("password"))
                .roles("USER").build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password(encoder.encode("password2"))
                .roles("USER").build();

        UserDetails user3 = User.builder()
                .username("user3")
                .password(encoder.encode("password3"))
                .roles("USER").build();


        return new InMemoryUserDetailsManager(admin,user, user2, user3);
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/images/**","/", "/catalog","/auth","/list-skates","/admin-creat","/update-product").permitAll()
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/admin").authenticated())
                .formLogin(form->form
                        .loginPage("/auth")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/admin", true)
                        .permitAll()).
                logout(l->l.logoutSuccessUrl("/auth"))

                .build();


//        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
