package br.com.nailtonvieira.ap_unifor.infra.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.nailtonvieira.ap_unifor.model.entity.Usuario;
import br.com.nailtonvieira.ap_unifor.repository.UsuarioRepository;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = this.repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
