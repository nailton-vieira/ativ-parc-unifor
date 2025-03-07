package br.com.nailtonvieira.ap_unifor.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String password;

}