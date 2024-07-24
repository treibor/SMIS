package com.smis.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.smis.view.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;

//@EnableWebSecurity
//@Configuration
public class SecurityConfigs extends VaadinWebSecurityConfigurerAdapter {

    private static final String LOGIN_PROCESSING_URL = "/login";
    private static final String LOGIN_FAILURE_URL = "/login?error";
    private static final String LOGIN_URL = "/login";
    private static final String LOGOUT_SUCCESS_URL = "/login";

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Vaadin handles CSRF internally, so CSRF protection is disabled.
        http.csrf(csrf -> csrf.disable())
            // Register our CustomRequestCache, which saves unauthorized access attempts, so
            // the user is redirected after login.
            .requestCache(requestCache -> requestCache.requestCache(new CustomRequestCache()))
            // Restrict access to our application.
            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                // Allow all Vaadin internal requests.
                //.requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()
                // Allow all requests by logged-in users.
                .anyRequest().authenticated())
            // Configure the login page.
            .formLogin(formLogin -> formLogin
                .loginPage(LOGIN_URL).permitAll()
                .loginProcessingUrl(LOGIN_PROCESSING_URL)
                .failureUrl(LOGIN_FAILURE_URL))
            // Configure logout
            .logout(logout -> logout.logoutSuccessUrl(LOGOUT_SUCCESS_URL))
            // Add security headers
            .headers(headers -> {
                //headers
                    //.contentSecurityPolicy(csp -> csp.policyDirectives("default-src 'self'; script-src 'self'; style-src 'self'; object-src 'none'; frame-ancestors 'none';"));
                headers.xssProtection(xss -> xss.block(true));
                headers.contentTypeOptions();
                headers.frameOptions(frameOptions -> frameOptions.deny());
                headers.httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true).maxAgeInSeconds(31536000));
            })
            // Add same site cookie attribute
            .sessionManagement(sessionManagement -> sessionManagement
                .sessionFixation().migrateSession()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        // Register the login view to the view access checker mechanism
        setLoginView(http, LoginView.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public HttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        Set<String> allowedMethods = new HashSet<>(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH"));
        firewall.setAllowedHttpMethods(allowedMethods);
        return firewall;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
            // Client-side JS
            "/VAADIN/**",
            // the standard favicon URI
            "/favicon.ico",
            // the robots exclusion standard
            "/robots.txt",
            // web application manifest
            "/manifest.webmanifest",
            "/sw.js",
            "/offline.html",
            // icons and images
            "/icons/**",
            "/images/**",
            "/styles/**",
            // (development mode) H2 debugging console
            "/h2-console/**");

        // Set the custom firewall
        web.httpFirewall(httpFirewall());
    }

    // Configure the session cookie to include SameSite=strict attribute
    
}
