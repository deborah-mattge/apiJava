package net.weg.api.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SeguroId {
    private Long seguradoraId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroId;

}
