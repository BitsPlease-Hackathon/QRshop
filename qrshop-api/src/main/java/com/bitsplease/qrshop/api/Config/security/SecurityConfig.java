package com.bitsplease.qrshop.api.Config.security;

import com.bitsplease.qrshop.security.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * @author Chrisostomos Bakouras
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CurrentUserDetailsService userDetailsService;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()

                .and()

                .requiresChannel()
                .anyRequest().requiresInsecure()

                .and()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()

                .authorizeRequests()

                .expressionHandler(webSecurityExpressionHandler())

                .regexMatchers(HttpMethod.GET, "\\/?").permitAll()
                .regexMatchers(HttpMethod.POST, "\\/customers").permitAll()
                .regexMatchers(HttpMethod.POST, "\\/orders").permitAll()
                .regexMatchers(HttpMethod.GET, "\\/products.*").permitAll()
                .anyRequest().authenticated()

                .and()

                .csrf().disable();
    }

    protected SecurityExpressionHandler<FilterInvocation> webSecurityExpressionHandler() {
        DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();

        defaultWebSecurityExpressionHandler.setApplicationContext(applicationContext);

        return defaultWebSecurityExpressionHandler;
    }
}
