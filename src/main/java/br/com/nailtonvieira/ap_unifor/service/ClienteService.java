package br.com.nailtonvieira.ap_unifor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nailtonvieira.ap_unifor.model.entity.Clientes;
import br.com.nailtonvieira.ap_unifor.model.entity.DadosCep;
import br.com.nailtonvieira.ap_unifor.repository.ClienteRepository;



@Service
public class ClienteService {

     @Autowired
    private ClienteRepository clienteRepository;

    private final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";

    public Clientes salvarCliente(Clientes cliente) {
        String cep = cliente.getEndereco().getCep();
        DadosCep endereco = buscarEnderecoPorCep(cep);
        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }

    private DadosCep buscarEnderecoPorCep(String cep) {
        String url = String.format(VIA_CEP_URL, cep);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, DadosCep.class);
    }

    public Iterable<Clientes> listarClientes() {
        return clienteRepository.findAll();
    }

    public Clientes buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}


