package br.com.nailtonvieira.ap_unifor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nailtonvieira.ap_unifor.dto.UsuarioDTO;
import br.com.nailtonvieira.ap_unifor.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
   

    @GetMapping
    public List<UsuarioDTO> listarTodosUsuarios() {
        return usuarioService.listarTodosUsuarios();
    }
}