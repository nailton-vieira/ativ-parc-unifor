package br.com.nailtonvieira.ap_unifor.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nailtonvieira.ap_unifor.dto.LoginRequestDTO;
import br.com.nailtonvieira.ap_unifor.dto.RegisterRequestDTO;
import br.com.nailtonvieira.ap_unifor.dto.ResponseDTO;
import br.com.nailtonvieira.ap_unifor.infra.security.TokenService;
import br.com.nailtonvieira.ap_unifor.model.entity.Usuario;
import br.com.nailtonvieira.ap_unifor.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        Usuario user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<Usuario> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()) {
            Usuario newUser = new Usuario();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setNome(body.nome());
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}