package com.codecampn.quarkus.app.template.db.model;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Getter
    @Column(name = "name", nullable = false)
    private String name;

    public Contract() {
    }

    public Contract(String name) {
        this.name = name;
    }
}
