package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
@AllArgsConstructor
public class CarroService {
    private CarroRepository carroRepository;



    public Carro buscarUm( Integer id){
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos(){
        return carroRepository.findAll();
    }
    public Collection<Carro> buscarCarrosSeguradora(Integer id ){
        return carroRepository.findBySeguro_SeguradoraId(id);
    }
    public Collection<Carro> buscarCarroMarca(String marca ){
        return carroRepository.findByMarca(marca);
    }
    public void deletar( Integer id){
        carroRepository.deleteById(id);
    }

    public Carro editar(CarroEdicaoDTO carroDTO) throws Exception {
        if(!carroRepository.existsById(carroDTO.getId())){
            throw new Exception("Há um carro com o id"+carroDTO.getId()+"cadastrado.");
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO,carro);
        return carroRepository.save(carro);
    }
    public Carro cadastrar(CarroCadastroDTO carroDTO) throws Exception {
        if(!carroRepository.existsByPlaca(carroDTO.getPlaca())){
            throw new Exception("Há um carro com o id"+carroDTO.getPlaca()+"cadastrado.");
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO,carro);
        return carroRepository.save(carro);

    }

}
