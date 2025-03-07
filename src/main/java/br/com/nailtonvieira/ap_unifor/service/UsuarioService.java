package br.com.nailtonvieira.ap_unifor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nailtonvieira.ap_unifor.dto.UsuarioDTO;
import br.com.nailtonvieira.ap_unifor.model.entity.Usuario;
import br.com.nailtonvieira.ap_unifor.repository.UsuarioRepository;

@Service
public class UsuarioService {

     @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioDTO(usuario.getNome()))
                .collect(Collectors.toList());

        }
}
