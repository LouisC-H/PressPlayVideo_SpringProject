package com.example.pressplayvideo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final BCryptPasswordEncoder encoder;

    public SecurityConfig(DataSource dataSource, BCryptPasswordEncoder encoder) {
        this.dataSource = dataSource;
        this.encoder = encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select user_name,user_password,user_enabled from user_entity where user_name=?")
                .authoritiesByUsernameQuery("select user_name,user_role from user_entity where user_name=?")
                .passwordEncoder(encoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/film-database").hasAnyAuthority("ADMIN")
                .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated()

                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/", true)

                .and().exceptionHandling().accessDeniedPage("/access-denied")
                .and().logout();
    }
}
