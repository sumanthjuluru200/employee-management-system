package com.ems.fullstatck.repository;

import com.ems.fullstatck.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long> {

    public Optional<Employee> findByEmail(String email);
}
