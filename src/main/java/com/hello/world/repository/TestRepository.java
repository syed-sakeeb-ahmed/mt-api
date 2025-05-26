package com.hello.world.repository;

import com.hello.world.model.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestTable, Integer> {
    @NativeQuery("select * from test_table")
    TestTable selectEverything();

}