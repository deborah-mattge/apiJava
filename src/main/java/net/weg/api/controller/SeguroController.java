package net.weg.api.controller;

import net.weg.api.model.entity.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

public class SeguroController {
    private SeguroService seguroService;
    @DeleteMapping("/{id}")
    public  void remover(@PathVariable Integer id ){
        seguroService.deletar(id);
    }
    @PostMapping
    public  void  inserir(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }
    @PutMapping
    public void atualizar (@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }
    @GetMapping("/{id}")
    public void buscar (@PathVariable Integer id ){
        seguroService.buscar(id);
    }
    @GetMapping
    public void buscar (){
        seguroService.buscar();
    }


}
