package net.weg.api.controller;

import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

public class SeguradoraController {
    private SeguradoraService seguradoraService;
    @DeleteMapping("/{id}")
    public  void remover(@PathVariable Integer id ){
        seguradoraService.deletar(id);
    }
    @PostMapping
    public  void  inserir(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }
    @PutMapping
    public void atualizar (@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }
    @GetMapping("/{id}")
    public void buscar (@PathVariable Integer id ){
        seguradoraService.buscar(id);
    }
    @GetMapping()
    public void buscar (){
        seguradoraService.buscar();
    }

}
