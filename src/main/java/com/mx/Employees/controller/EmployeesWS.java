package com.mx.Employees.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Employees.dao.EmployeesDao;
import com.mx.Employees.dominio.EmployeeRequestDTO;
import com.mx.Employees.dominio.EmployeeResponseDTO;
import com.mx.Employees.dominio.Employees;
import com.mx.Employees.dominio.Genders;
import com.mx.Employees.dominio.Jobs;
@RequestMapping("/api/Employees/")
@RestController
@CrossOrigin
public class EmployeesWS {

	@Autowired
	EmployeesDao dao;
	//http://localhost:9005/api/Employees/listar
	@GetMapping(value="listar")
	public List<Employees>listar(){
		return dao.findAll();
	}
	//http://localhost:9005/api/Employees/insertar

	@PostMapping(value="insertar")
	public ResponseEntity<EmployeeResponseDTO> insertar(@RequestBody EmployeeRequestDTO dto) {
	    EmployeeResponseDTO response = new EmployeeResponseDTO();
	    try {
	        Employees employee = new Employees();
	        employee.setNombre(dto.getName());
	        employee.setApellido(dto.getLast_name());
	        employee.setfNacimiento(dto.getBirthdate());

	        // Buscar los catálogos
	        Jobs job = new Jobs();
	        job.setId(dto.job_id);
	        employee.setJobs(job);

	        Genders gender = new Genders();
	        gender.setId(dto.gender_id);
	        employee.setGenders(gender);

	        Employees nuevo = dao.save(employee);

	        response.id = (long) nuevo.getId();
	        response.success = true;
	       

	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        response.success = false;
	        return ResponseEntity.status(500).body(response);
	    }
	}
	
}
