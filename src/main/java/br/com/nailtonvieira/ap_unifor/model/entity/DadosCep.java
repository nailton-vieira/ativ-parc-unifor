package br.com.nailtonvieira.ap_unifor.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class DadosCep {

    private String cep;
    private String logradouro;
  //private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
  //private String ibge;
  //private String gia;
  //private String ddd;
  //private String siafi;

}