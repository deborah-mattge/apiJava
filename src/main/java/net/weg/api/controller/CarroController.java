package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {
    private CarroService carroService ;
    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarCarro(@PathVariable(value="id") Integer id){
      try{
          return new ResponseEntity<>(carroService.buscarUm(id),HttpStatus.OK);

      }catch (NoSuchElementException e){
          return new ResponseEntity(HttpStatus.NOT_FOUND);
      }
    }
    @GetMapping()
    public ResponseEntity<Collection<Carro>> buscarTodos(){
        return new ResponseEntity<>(  carroService.buscarTodos(), HttpStatus.OK);

    }
    @DeleteMapping
    public void deletar(@RequestParam  Integer id){
        carroService.deletar(id);
    }
    @PostMapping
    public ResponseEntity<Carro> inserir(@RequestBody CarroCadastroDTO carroCadastroDTO){
        try {

            return new ResponseEntity(carroService.cadastrar(carroCadastroDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PutMapping()
    public  ResponseEntity<Carro> atualizar(@RequestBody CarroEdicaoDTO carro){
        try{
            return new ResponseEntity(carroService.editar(carro), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/seguradora/{id}")
    public ResponseEntity<Collection<Carro>>buscarCarroSeguradora(@PathVariable Integer id){
        return new ResponseEntity<>(  carroService.buscarCarrosSeguradora(id), HttpStatus.OK);
    }
    @GetMapping("/marca")
    public ResponseEntity<Collection<Carro>>buscarCarrosMarca(@RequestParam String marca){
        return new ResponseEntity<>(  carroService.buscarCarroMarca(marca), HttpStatus.OK);
    }
}
