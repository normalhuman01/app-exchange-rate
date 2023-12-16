package pe.com.test.challenge.infrastructure.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import pe.com.test.challenge.infrastructure.security.AuthenticationManager;
import pe.com.test.challenge.infrastructure.security.SecurityContextRepository;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http.authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/auth/**").permitAll()
                        .anyExchange().authenticated())
                .httpBasic(customizer -> customizer.disable())
                .formLogin(customizer -> customizer.disable())
                .csrf(customizer -> customizer.disable())
                .exceptionHandling(customizer ->
                        customizer.authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED)))
                .authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository)
                .build();
    }

}
