package com.ecommerce.demo.onlineshop.configuration;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.proc.DefaultJOSEObjectTypeVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors()
            .and()
            .authorizeHttpRequests((authz) -> authz.requestMatchers(HttpMethod.GET, "/item/**")
                                                   .permitAll()
                                                   .requestMatchers("/cart/**")
                                                   .authenticated()
                                                   .anyRequest()
                                                   .authenticated())
            .oauth2ResourceServer()
            .jwt();
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder(OAuth2ResourceServerProperties properties) {
        //return JwtDecoders.fromIssuerLocation("https://api.asgardeo.io/t/chinthakaorg/oauth2/token");
        return NimbusJwtDecoder.withJwkSetUri(properties.getJwt().getJwkSetUri())
                               .jwtProcessorCustomizer(jwtCustomizer -> {
                                   jwtCustomizer.setJWSTypeVerifier(new DefaultJOSEObjectTypeVerifier<>(new JOSEObjectType("at+jwt")));
                               })
                               .build();
    }
}
