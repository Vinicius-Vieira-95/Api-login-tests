package com.vnc.login.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vnc.login.data.DetalheUsuarioDataImpl;
import com.vnc.login.entities.Usuario;
import com.vnc.login.repositories.UsuarioRepository;

@Service
public class DetalheUsuarioServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);

        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado" + username);
        }

        return new DetalheUsuarioDataImpl(usuario);
    }
    
}
