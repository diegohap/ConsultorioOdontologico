package com.DH.trabajoIntegrador.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    //@JsonIgnore
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    private Long id;
    @Column
    private String nombre;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private UsuarioRol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // le otorga autoridad al rol del usuario
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.name());
        // transforma el unico elemento en una coleccion
        return Collections.singletonList(grantedAuthority);
    }

    public String getPassword() { return password; }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Usuario(String nombre, String userName, String email, String password, UsuarioRol rol) {
        this.nombre = nombre;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public Usuario() {
    }
}
