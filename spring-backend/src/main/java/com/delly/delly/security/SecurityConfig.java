package com.delly.delly.security;

import com.delly.delly.domain.role.RoleEnum;
import com.delly.delly.security.fillter.CustomAuthenticationFilter;
import com.delly.delly.security.fillter.CustomAuthorizationFilter;
import com.delly.delly.security.utils.RestAuthenticationFailureHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/client").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/client/**").hasAuthority(RoleEnum.CLIENT.toString());
        http.authorizeRequests().antMatchers("/orders").hasAuthority(RoleEnum.OFFICE_WORKER.toString());
        http.authorizeRequests().antMatchers("/order").hasAuthority(RoleEnum.CLIENT.toString());
        http.authorizeRequests().antMatchers("/order/**").hasAuthority(RoleEnum.COURIER.toString());
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/courier").hasAuthority(RoleEnum.OFFICE_WORKER.toString());
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/couriers").hasAuthority(RoleEnum.OFFICE_WORKER.toString());
        http.authorizeRequests().antMatchers("/courier/**").hasAuthority(RoleEnum.COURIER.toString());
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    RestAuthenticationFailureHandler authenticationFailureHandler() {
        return new RestAuthenticationFailureHandler();
    }

}

