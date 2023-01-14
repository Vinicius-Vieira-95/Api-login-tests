package com.vnc.login.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vnc.login.data.DetalheUsuarioDataImpl;
import com.vnc.login.entities.Usuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter{

    public static final int TOKEN_EXPIRACAO = 600_000; //10 minutos
    public static final String TOKEN_SENHA = "463408a1-54c9-4307-bb1c-6cced559f5a7";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    //Autenticação do usuário
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{

        try {
            Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getEmail(),
                    usuario.getSenha(),
                    new ArrayList<>())); // Lista de permissões ROLES
        }
         catch (IOException e) {
           throw new RuntimeException("Falha ao autenticar usuario : ", e);
        }
    }

    //Gerar o token
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, jakarta.servlet.FilterChain chain, Authentication authResult) throws IOException{

        DetalheUsuarioDataImpl detalheUsuarioDataImpl = (DetalheUsuarioDataImpl) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(detalheUsuarioDataImpl.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO)) // tempo de expiração do token, pode ser opcional
                .sign(Algorithm.HMAC512(TOKEN_SENHA)); //assinar o token
        
        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
