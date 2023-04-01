package com.guardian.tales.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "element")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "element_id", columnDefinition = "int", nullable = false)
    private int elementId;

    @Column(name = "name", length = 20)
    private String name;
}
