package br.com.nailtonvieira.ap_unifor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nailtonvieira.ap_unifor.model.entity.Clientes;



public interface ClienteRepository extends JpaRepository<Clientes, Long> {
}
