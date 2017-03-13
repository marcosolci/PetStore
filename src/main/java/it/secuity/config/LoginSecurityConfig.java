package it.secuity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired 
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
        .withUser("user")
        .password("user") 
        .authorities("ROLE_USER");
    } 
          
    @Override
    public void configure(WebSecurity web) throws Exception {
      web
        .ignoring()
           .antMatchers("/resources/**"); // #3
    }
    
    @Override 
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/*").permitAll();
        /*
        http
        .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/loginPage")
            .permitAll()
            .and()
        .logout()
            .permitAll();
            */
        /*
        http.authorizeRequests()
        .antMatchers("/homePage").access("hasRole('ROLE_USER')")
        .and()
        .formLogin().loginPage("/loginPage")
        .defaultSuccessUrl("/admin/homePage")
        .failureUrl("/loginPage?error")
        .usernameParameter("username").passwordParameter("password")                            
        .and() 
        .logout().logoutSuccessUrl("/loginPage?logout"); 
        */
                
    }
}