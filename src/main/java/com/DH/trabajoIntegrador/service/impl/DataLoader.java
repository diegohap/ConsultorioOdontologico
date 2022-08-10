package com.DH.trabajoIntegrador.service.impl;

import com.DH.trabajoIntegrador.entities.Usuario;
import com.DH.trabajoIntegrador.entities.UsuarioRol;
import com.DH.trabajoIntegrador.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    public DataLoader(IUsuarioRepository iUsuarioRepository){
        this.iUsuarioRepository = iUsuarioRepository;
    }

    // esto se ejecuta cuando arranca la aplicacion
    // carga a la BD un usuario harcodeado
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Encriptador de password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash1 = passwordEncoder.encode("erikita92");
        String hash2 = passwordEncoder.encode("admin");

        Usuario usuario1 = new Usuario("Erika", "erikita", "erikita@gmail.com", hash1, UsuarioRol.ROLE_USER);
        Usuario usuario2 = new Usuario("Administrador", "admin", "erikita@gmail.com", hash2, UsuarioRol.ROLE_ADMIN);
        //iUsuarioRepository.save(usuario2);
    }
}
