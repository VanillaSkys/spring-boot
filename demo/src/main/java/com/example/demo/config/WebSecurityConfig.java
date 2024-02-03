package com.example.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


	public WebSecurityConfig() {
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors(config -> {
            CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowCredentials(true);
            cors.setAllowedOriginPatterns(Collections.singletonList("http://*"));
            cors.addAllowedHeader("*");
            cors.addAllowedMethod("GET");
            cors.addAllowedMethod("POST");
            cors.addAllowedMethod("PUT");
            cors.addAllowedMethod("DELETE");
            cors.addAllowedMethod("OPTIONS");

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", cors);

            config.configurationSource(source);
        })
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/api/v1/public/**").permitAll()
				.requestMatchers("/", "/api/v1/user/**").hasRole("USER")
				.requestMatchers("/", "/api/v1/admin/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
			)
			// .formLogin((form) -> form
			// 	.loginPage("/login")
			// 	.permitAll()
			// )
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
