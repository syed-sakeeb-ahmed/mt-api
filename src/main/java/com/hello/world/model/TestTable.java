package com.hello.world.model;

import jakarta.persistence.*;

@Entity
@Table( name = "test_table")
public class TestTable {

    @Id
    @Column(nullable = false)
    private Integer id;

    public TestTable() {}

    public TestTable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}