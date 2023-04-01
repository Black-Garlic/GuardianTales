package com.guardian.tales.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "chain_type")
public class ChainType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chain_type_id", columnDefinition = "int", nullable = false)
    private int chainTypeId;

    @Column(name = "name", length = 20)
    private String name;
}
