package br.edu.utfpr.tsi.prova02.domain.security;

import br.edu.utfpr.tsi.prova02.domain.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(@Qualifier(value = "userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                 .antMatchers("/webjars/**", "/h2-console/**").permitAll()
                 .anyRequest()
                 .authenticated()
             .and()
             .formLogin()
                 .loginPage("/login")
                 .failureUrl("/login?error=true")
                 .permitAll()
                 .and()
                    .exceptionHandling().accessDeniedPage("/acesso_negado")
             .and()
             .logout()
                 .logoutSuccessUrl("/login?logout=true")
                 .invalidateHttpSession(true)
                 .permitAll()
             .and()
             .csrf()
                .disable()
                .headers()
                    .frameOptions().disable()
             .and()
             .addFilter(new SecurityFilter(authenticationManager(), userDetailsService));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
