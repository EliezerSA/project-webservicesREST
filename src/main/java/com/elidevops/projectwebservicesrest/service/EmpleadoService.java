/**
 * 
 */
package com.elidevops.projectwebservicesrest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.elidevops.projectwebservicesrest.entity.Empleado;

/**
 * @author EliDevops
 *
 */

public class EmpleadoService {
	
	/*
	 * Metodo que permite consultar un empleado por su id.
	 * @param numeroEmpleado {@link String} numero del empleado.
	 * @return {@link Empleado} empleado consultado
	 * */
	
	public Empleado consultarEmpleadoPorNumeroEmpleado(String numeroEmpleado) {
		
		List<Empleado> empleadosConsultados = this.consultarEmpleados();
		
		for(Empleado empleadoConsultado :  empleadosConsultados) {
			if(empleadoConsultado.getNumeroEmpleado().equals(numeroEmpleado)) {
				return empleadoConsultado;
			
			}
		}
		//Si no lo encuentra que regrese un  null
		return null;
		
	}
	
	/*
	 * Metodo que simula la consulta de un empleado.
	 * @return {@link Empleado} empleado consultado
	 * */
	
	public Empleado consultarEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("1234");
		empleado.setNombre("Diego");
		empleado.setPrimerApellido("Vazquez");
		empleado.setSegundoApellido("Martinez");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(24);
		
		return empleado;
	}
	/*
	 * Metodo que permite consultar la lista de empleados.
	 * @return {@link List} lista consultada
	 * */
	
	public List<Empleado> consultarEmpleados(){
		List<Empleado> empleados = new ArrayList();
		
		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("1234");
		empleado.setNombre("Diego");
		empleado.setPrimerApellido("Vazquez");
		empleado.setSegundoApellido("Martinez");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(24);
		
		Empleado empleadoNuevo = new Empleado();
		empleadoNuevo.setNumeroEmpleado("5678");
		empleadoNuevo.setNombre("Mario");
		empleadoNuevo.setPrimerApellido("Gomez");
		empleadoNuevo.setSegundoApellido("Santos");
		empleadoNuevo.setFechaCreacion(LocalDateTime.now());
		empleadoNuevo.setEdad(34);
		
		empleados.add(empleado);
		empleados.add(empleadoNuevo);
		
		return empleados;
	}

}
