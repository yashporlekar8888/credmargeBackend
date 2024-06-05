package com.credmarg.credmarg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credmarg.credmarg.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
