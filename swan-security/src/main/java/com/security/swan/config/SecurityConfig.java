package com.security.swan.config;

import com.security.swan.security.AuthProvider;
import com.security.swan.security.CommonAuthorityHandle;
import com.security.swan.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    public UserDetailServiceImpl userDetailService;
    @Resource
    DataSource dataSource;
    @Resource
    AuthProvider authProvider;
    @Resource
    CommonAuthorityHandle commonAuthorityHandle;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //登录相关
        http.formLogin()
                .successForwardUrl("/login/loginSuccess")
                .failureForwardUrl("/login/loginFail");
        http.logout()
                .logoutSuccessUrl("/login/logoutSuccess");
        //请求权限相关 基于access的权限控制
        http.authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/index/authority").hasAuthority("app:insert")
                .antMatchers("/index/authority1").hasAuthority("app:all")
                .antMatchers("/index/role").hasRole("admin")
                .antMatchers("/index/role1").authenticated()
                .antMatchers("/index/access1").access("permitAll")
                .antMatchers("/index/access2").access("hasRole('abc')")
                .antMatchers("/index/access3").access("@TestAccessHandleImpl.isAuthority(request,authority)")
                .anyRequest().authenticated();
        http.csrf().disable();
        http.exceptionHandling()
                .accessDeniedHandler(commonAuthorityHandle);
        http.rememberMe()
                .tokenValiditySeconds(3600)
                .userDetailsService(userDetailService)
                .tokenRepository(persistentTokenRepository());
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //第一次启动建表
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
