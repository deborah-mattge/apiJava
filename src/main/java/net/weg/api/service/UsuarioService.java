package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Cliente;
import net.weg.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService {
    private ClienteRepository clienteRepository;
    public void salvar(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Cliente buscarUm(Integer id) {
        Optional<Cliente> usuarioOptional =  clienteRepository.findById(id);
        Cliente cliente = usuarioOptional.get();
        return cliente;
    }

    public Collection<Cliente> buscarTodos() {
        Collection<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
