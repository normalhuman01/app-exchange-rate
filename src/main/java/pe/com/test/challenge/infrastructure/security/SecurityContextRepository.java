package pe.com.test.challenge.infrastructure.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityContextRepository implements ServerSecurityContextRepository {

    private final AuthenticationManager authenticationManager;

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {

        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {

        String key = "Bearer ";

        return Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("Authorization"))
                .filter(authorization -> authorization.startsWith(key))
                .map(authorization -> authorization.substring(key.length()))
                .doOnSuccess(authorization -> log.debug("JWT Token -> {}", authorization))
                .flatMap(token -> Mono.just(new UsernamePasswordAuthenticationToken(token, token, null)))
                .flatMap(auth -> authenticationManager.authenticate(auth).map(SecurityContextImpl::new));
    }

}
