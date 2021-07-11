package com.example.demo.JWT;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.UsersService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifier extends OncePerRequestFilter {

    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepo userRepo;


    public JwtTokenVerifier(SecretKey secretKey, JwtConfig jwtConfig) {
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String authorizationHeader = httpServletRequest.getHeader(jwtConfig.getAuthorizationHeader());
        if (authorizationHeader==null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String token = null;
        try {
            token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");

            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);

            Claims body = claimsJws.getBody();
            String username = body.getSubject();
            System.out.println("search for username : "+username);
            User user = usersService.getUser(username);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    user.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (JwtException e) {
            throw new IllegalStateException(String.format("Token %s cannot be truest", token));
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
