package br.com.nailtonvieira.ap_unifor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nailtonvieira.ap_unifor.model.entity.Clientes;
import br.com.nailtonvieira.ap_unifor.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Clientes criarCliente(@RequestBody Clientes cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping
    public Iterable<Clientes> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Clientes buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
}