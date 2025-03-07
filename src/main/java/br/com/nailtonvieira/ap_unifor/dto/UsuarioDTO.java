package br.com.nailtonvieira.ap_unifor.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter // Gera os getters automaticamente
@Setter // Gera os setters automaticamente
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos

public class UsuarioDTO {

    private String nome;
    
}
