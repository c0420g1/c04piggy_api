package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private com.example.demo.configuration.JWTAuthenticationFilter jwtAuthenticationFilter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers("/", "/accountIdFirst","/customerIdFirst").permitAll().and()
               .authorizeRequests().antMatchers(HttpMethod.POST, "/register", "/login").permitAll()
//                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new com.example.demo.configuration.JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
//    }
//        http.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login","/news-feed","/account-user").permitAll().and().
//                authorizeRequests().antMatchers("/admin","/api/admin/*").access("hasRole('ROLE_ADMIN')").and().
//                authorizeRequests().antMatchers("/news-feed/{id}/post-comment").access("hasAnyRole('ROLE_ADMIN','ROLE_USER', 'ROLE_EMPLOYEE')").and().
//                authorizeRequests().antMatchers("/news-feed/employee/post-new-feed").access("hasRole('ROLE_EMPLOYEE')").and().
//                authorizeRequests().antMatchers("/user").access("hasRole('ROLE_USER')")
//                .anyRequest().authenticated()
//                .and().cors();
//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
