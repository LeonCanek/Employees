package com.mx.Employees.dominio;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class EmployeesHours {
@Id
int id;
@Column(name="WORKED_HOURS")
int horasTrabajadas;
@Column(name="WORKED_DATE")
Date fechaTrabajada;

@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="EMPLOYEE_ID")
Employees employee;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getHorasTrabajadas() {
	return horasTrabajadas;
}

public void setHorasTrabajadas(int horasTrabajadas) {
	this.horasTrabajadas = horasTrabajadas;
}

public Date getFechaTrabajada() {
	return fechaTrabajada;
}

public void setFechaTrabajada(Date fechaTrabajada) {
	this.fechaTrabajada = fechaTrabajada;
}


}
