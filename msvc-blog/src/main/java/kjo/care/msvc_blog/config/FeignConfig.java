package kjo.care.msvc_blog.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            JwtAuthenticationToken authentication =
                    (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null) {
                String token = authentication.getToken().getTokenValue();
                requestTemplate.header("Authorization", "Bearer " + token);
            } else {
                System.out.println("No hay autenticación en el contexto");
            }
        };
    }
}
