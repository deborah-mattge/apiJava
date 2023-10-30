package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Cliente;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {
    private UsuarioService usuarioService;
    @GetMapping("/{id}")
    public Cliente buscarUsuario(@PathVariable(value="id") Integer id){
        return usuarioService.buscarUm(id);
    }
    @GetMapping()
    public Collection<Cliente> buscarTodos(){
        return usuarioService.buscarTodos();
    }
    @DeleteMapping
    public void deletar(@RequestParam  Integer id){
        usuarioService.deletar(id);
    }
    @PostMapping
    public void inserir(@RequestBody Cliente cliente){
        usuarioService.salvar(cliente);
    }
    @PutMapping
    public  void atualizar(@RequestBody Cliente cliente){
        usuarioService.salvar(cliente);
    }

}
