package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tb_seguradora")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Seguradora {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long cnpj;
    @OneToOne
    private Endereco endereco;
    @ManyToMany
    @JsonIgnore
    private Set<Cliente> clientes;

}
