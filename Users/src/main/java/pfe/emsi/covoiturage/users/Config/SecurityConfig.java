package pfe.emsi.covoiturage.users.Config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity security) throws Exception {

        security
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(login -> login.disable())
                .authorizeHttpRequests(
                        auth ->
                                auth
//                                        .requestMatchers("/h2-console/*","/api/*").permitAll()
                                        .requestMatchers("/**", "/api/auth/signup", "/api/auth/login", "/api/auth/valid", "/h2-console/*", "/verify", "/api", "/h2-console", "/api/region/get", "/api/crop/get", "/api/crop/get/**").permitAll()
                                        .anyRequest().authenticated()
                        // .anyRequest().permitAll()
                )
                .headers(AbstractHttpConfigurer::disable);
        return security.build();
    }


}
