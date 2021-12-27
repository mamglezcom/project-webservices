package com.mamglez.projectwebservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mamglez.projectwebservices.entity.Empleado;

public class EmpleadoService {
	
	public Empleado consultarEmpleadoPorNumero(String numeroEmpleado) {
		List<Empleado> empleados = this.consultarEmpleados();
		for(Empleado empleado : empleados) {
			if(empleado.getNumeroEmpleado().equals(numeroEmpleado)) {
				return empleado;
			}
		}
		return null;
	}
	
	public Empleado consultarEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("12345");
		empleado.setNombre("paco");
		empleado.setPrimerApellido("paquito");
		empleado.setSegundoApellido("pacote");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(33);
		
		return empleado;
	}
	
	public List<Empleado> consultarEmpleados(){
		List<Empleado> empleados = new ArrayList();
		
		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("123456");
		empleado.setNombre("paco");
		empleado.setPrimerApellido("paquito");
		empleado.setSegundoApellido("pacote");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(33);
		
		Empleado empleadoNuevo = new Empleado();
		empleadoNuevo.setNumeroEmpleado("12345");
		empleadoNuevo.setNombre("paco");
		empleadoNuevo.setPrimerApellido("paquito");
		empleadoNuevo.setSegundoApellido("pacote");
		empleadoNuevo.setFechaCreacion(LocalDateTime.now());
		empleadoNuevo.setEdad(33);
		
		empleados.add(empleado);
		empleados.add(empleadoNuevo);
		
		return empleados;
	}

}
