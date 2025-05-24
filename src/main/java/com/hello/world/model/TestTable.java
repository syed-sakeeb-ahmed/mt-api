package com.hello.world.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestTable {

    @Id
    @Column(nullable = false)
    Integer id;
}
