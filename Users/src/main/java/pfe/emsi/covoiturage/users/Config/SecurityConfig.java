package pfe.emsi.covoiturage.users.Config;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pfe.emsi.covoiturage.users.Services.CustomUserDetailsService;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService)
    {
        this.userDetailsService = userDetailsService;
    }

    @Value("${jwt.key}")
    private String jwtKey;
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
//                                        .requestMatchers("/h2-console","/h2-console/**","/graphiql**","/graphql").permitAll()
//                                        .anyRequest().authenticated()
                                         .requestMatchers("/**").permitAll()
                )
                .headers(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return security.build();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(this.passwordEncoder());
        return provider;
    }


    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authProvider())
                .build();
    }

    @Bean
    JwtEncoder jwtEncoder()
    {
        return new NimbusJwtEncoder(new ImmutableSecret<>(jwtKey.getBytes()));
    }
    @Bean
    org.springframework.security.oauth2.jwt.JwtDecoder jwtDecoder()
    {
        byte[] bytes = jwtKey.getBytes();
        SecretKeySpec secret = new SecretKeySpec(bytes,0, bytes.length, "RSA");
        return NimbusJwtDecoder.withSecretKey(secret).macAlgorithm(MacAlgorithm.HS256).build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOriginPatterns("http://127.0.0.1*","http://localhost*");
                // registry.addMapping("/verify").allowedOrigins("*").allowedMethods("*");
                // registry.addMapping("/**")
                // .allowedOrigins("*")
                // .allowedMethods("*")
                // .allowedHeaders("*")
                // .exposedHeaders("*");
            }
        };
    }


}
