package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_habilitacao")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Habilitacao {
    @Id
    @GeneratedValue (strategy =  GenerationType.TABLE)
    private  Integer id;
    private Long registro, cpf;
    private String orgaoEmissor;
}
