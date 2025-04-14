package com.mx.Employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Employees.dominio.Employees;

@Repository
public interface EmployeesDao extends JpaRepository<Employees, Integer>{

}
