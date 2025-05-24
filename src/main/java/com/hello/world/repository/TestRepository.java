package com.hello.world.repository;

import com.hello.world.model.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestTable, Integer> {

}
