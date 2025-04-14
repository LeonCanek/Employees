package com.mx.Employees.dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // o AUTO, dependiendo del setup
	@SequenceGenerator(name = "employee_seq_gen", sequenceName = "employees_seq", allocationSize = 1)

	int id;
	@Column(name = "NAME")
	String nombre;
	@Column(name = "LAST_NAME")
	String apellido;
	@Column(name = "BIRTHDATE")
	LocalDate fNacimiento;

	/*
	 * 
	 * CREATE TABLE EMPLOYEE_WORKED_HOURS( ID NUMBER PRIMARY KEY, EMPLOYEE_ID
	 * NUMBER, WORKED_HOURS NUMBER, WORKED_DATE DATE, FOREIGN KEY(EMPLOYEE_ID)
	 * REFERENCES EMPLOYEES(ID) );
	 * 
	 * 
	 * CREATE TABLE EMPLOYEES( ID NUMBER PRIMARY KEY, GENDER_ID NUMBER, JOB_ID
	 * NUMBER, NAME VARCHAR2(255), LAST_NAME VARCHAR2(255), BIRTHDATE DATE, FOREIGN
	 * KEY (GENDER_ID) REFERENCES GENDERS(ID), FOREIGN KEY (JOB_ID) REFERENCES
	 * JOBS(ID) );
	 * 
	 */
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="JOB_ID")
	Jobs jobs;
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="GENDER_ID")
	Genders genders;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimiento(LocalDate fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	public Genders getGenders() {
		return genders;
	}
	public void setGenders(Genders genders) {
		this.genders = genders;
	}

	
}
