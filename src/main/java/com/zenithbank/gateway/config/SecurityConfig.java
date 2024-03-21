package com.zenithbank.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authConfig -> {
                    authConfig.requestMatchers("/swagger-ui/**","/webjars/**","/configuration/ui","/swagger-resources","/v2/api-docs","/v3/api-docs").permitAll();
                    authConfig.requestMatchers("/swagger-resources/**").permitAll();
                    authConfig.requestMatchers("/swagger-ui.html").permitAll();
                    authConfig.requestMatchers("/api/v1/auth/**").permitAll();
                    authConfig.requestMatchers("/v3/api-docs/**").permitAll();
                    authConfig.requestMatchers("/v2/api-docs/**").permitAll();
                    authConfig.requestMatchers("/v3/api-docs.yaml").permitAll();
                    authConfig.requestMatchers("/swagger-ui/**").permitAll();
                    authConfig.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }


}
