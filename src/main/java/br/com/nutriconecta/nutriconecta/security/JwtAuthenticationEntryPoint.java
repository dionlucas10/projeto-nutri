package br.com.nutriconecta.nutriconecta.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    @Override
    public void commence(HttpServletRequest request,
                        HttpServletResponse response,
                        AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
        final String json = String.format(
                "{\"timestamp\": \"%s\", \"status\": %d, \"error\": \"Acesso Não Autorizado\", \"message\": \"%s\", \"path\": \"%s\"}",
                LocalDateTime.now(),
                HttpServletResponse.SC_UNAUTHORIZED,
                authException.getMessage(),
                request.getServletPath()
        );
        
        response.getWriter().write(json);
    }
}
