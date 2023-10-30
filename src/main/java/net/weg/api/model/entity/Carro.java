package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.api.model.dto.CarroCadastroDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_carro")
public class Carro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private String marca ;
   private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
    @OneToOne(mappedBy = "veiculo")
    private Seguro seguro;
    public Carro(CarroCadastroDTO carroCadastroDTO){
        this.ano=carroCadastroDTO.getAno();
        this.cor = carroCadastroDTO.getCor();
        this.marca=carroCadastroDTO.getMarca();
        this.preco =carroCadastroDTO.getPreco();
        this.modelo=carroCadastroDTO.getModelo();
    }







}
