package com.faketri.market.infastructure.config.web.Authentication;

import com.faketri.market.infastructure.user.gateway.UserDetailsServerImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * The type Jwt authentication filter.
 *
 * @author Dmitriy Faketri
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /**
     * The constant BEARER_PREFIX.
     */
    public static final String                BEARER_PREFIX = "Bearer ";
    /**
     * The constant HEADER_NAME.
     */
    public static final String                HEADER_NAME   = "Authorization";
    private final       JwtService            jwtService;
    private final       UserDetailsServerImpl userDetailsServer;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain
    ) throws ServletException, IOException, AuthenticationException {

        var authHeader = request.getHeader(HEADER_NAME);
        if (StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader,
                                                                       BEARER_PREFIX
        )) {
            filterChain.doFilter(request, response);
            return;
        }
        var jwt = authHeader.substring(BEARER_PREFIX.length());
        var username = jwtService.extractUserName(jwt);
        if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext()
                                                                     .getAuthentication() == null) {
            UserDetails userDetails =
                    userDetailsServer.loadUserByUsername(username);
            if (jwtService.isTokenValid(jwt, userDetails)) {
                SecurityContext context =
                        SecurityContextHolder.createEmptyContext();
                var authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }
        }
        filterChain.doFilter(request, response);
    }

}