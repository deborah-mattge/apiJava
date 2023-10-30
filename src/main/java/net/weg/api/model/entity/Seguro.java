package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_plano")
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(SeguroId.class)
public class Seguro {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Integer id;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroId;
    @Id
    private Long seguradoraId;
    @EmbeddedId
    private SeguroId id;
    private Double valorFranquia;
    private String descricao;
    @ManyToOne
    @MapsId("seguradoraId")
    private Seguradora seguradora;
    @OneToOne
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

}
