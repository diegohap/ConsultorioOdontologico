package com.DH.trabajoIntegrador.service.impl;

import com.DH.trabajoIntegrador.entities.Usuario;
import com.DH.trabajoIntegrador.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository iUsuarioRepository){
        this.iUsuarioRepository = iUsuarioRepository;
    }

    // carga un usuario
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = iUsuarioRepository.findByUserName(username);
        if(usuarioBuscado.isPresent())
            return usuarioBuscado.get(); // funciona porque ahora "usuarioBuscado" es tambien un UserDetails
        else
            throw new UsernameNotFoundException("Usuario no encontrado");
    }
}