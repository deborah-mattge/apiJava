package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String usuario;
    private  String senha;
    private Integer idade;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;

}
