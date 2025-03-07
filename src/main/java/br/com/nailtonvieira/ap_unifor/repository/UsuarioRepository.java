package br.com.nailtonvieira.ap_unifor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nailtonvieira.ap_unifor.model.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findAll();

}
