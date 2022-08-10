package com.DH.trabajoIntegrador.config;

import com.DH.trabajoIntegrador.entities.UsuarioRol;
import com.DH.trabajoIntegrador.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UsuarioService usuarioService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public WebSecurityConfig(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "static/**").permitAll()
                .antMatchers("/pacientes").hasRole("ADMIN")
                .antMatchers("/odontologos").hasRole("ADMIN")
                .antMatchers("/turnos").hasRole("USER")
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                //.defaultSuccessUrl("/pacientes", true)
                .and()
                .logout()
                .and()
                .csrf().disable()
                .httpBasic()    // con esto podemos usar postman
        ;
    }
}
// pacientes -> login -> pacientes
// login -> index