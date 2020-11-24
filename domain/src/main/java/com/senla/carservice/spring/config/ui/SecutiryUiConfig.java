package com.senla.carservice.spring.config.ui;

import com.senla.carservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@ComponentScan("com.senla.carservice.security")
@EnableWebSecurity
@Profile("ui")
public class SecutiryUiConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService userService;

    @Autowired
    @Qualifier("accessDeniedHandler403")
    private AccessDeniedHandler accessDeniedHandler;



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().disable()
                .csrf().disable()
                .formLogin()
                .loginPage( "/login" )
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession( true )
                .clearAuthentication( true )
                .logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
                .and()
                .exceptionHandling().accessDeniedHandler( accessDeniedHandler )
                /*.authenticationEntryPoint(accessDeniedHandler)*/
                .and()
                .authorizeRequests()
                .antMatchers("/", "/registration","/logout","error","/login").permitAll()
                .antMatchers("/masters/**","/places/**").hasRole("ADMIN")
                .antMatchers("/orders/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()

        ;

    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
