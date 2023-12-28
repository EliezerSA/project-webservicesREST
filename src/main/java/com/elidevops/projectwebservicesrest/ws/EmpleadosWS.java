/**
 * 
 */
package com.elidevops.projectwebservicesrest.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.elidevops.projectwebservicesrest.entity.Empleado;
import com.elidevops.projectwebservicesrest.service.EmpleadoService;

/**
 * @author EliDevops
 * Webservice generado con Jersey
 *
 */
@Path("empleadosWS")
public class EmpleadosWS {
	
	//Creamos la instancia
	private EmpleadoService empleadoService = new EmpleadoService();
	
	@GET
	@Path("test")
	public String test() {
		return "Probando webservices con Jersey";
	}
	
	/*
	 * Funcion para obtener un objeto de tipo empleado*/
	@GET
	@Path("consultarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON )
	public Empleado consultarEmpleado() {
		return this.empleadoService.consultarEmpleado();
	}

	/*
	 * Funcion para obtener una lista tipo empleado*/
	@GET
	@Path("consultarEmpleados")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON )
	public List<Empleado> consultarEmpleados(){
		return this.empleadoService.consultarEmpleados();
	}
	
	/*
	//Pasamos un parametro
	@GET
	@Path("consultarEmpleadoPorNumeroEmpleado/{numEmp}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON )
	public Empleado consultarEmpleadoPorNumeroEmpleado(@PathParam("numEmp")String numeroEmpleado) {//Este valor debe hacer match en nuestri path
		return this.empleadoService.consultarEmpleadoPorNumeroEmpleado(numeroEmpleado);
	}*/
	
	//Pasamos un parametro
	//Ahora uno con el tipo RESPONSE
		@GET
		@Path("consultarEmpleadoPorNumeroEmpleado/{numEmp}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON )
		public Response  consultarEmpleadoPorNumeroEmpleado(@PathParam("numEmp")String numeroEmpleado) {//Este valor debe hacer match en nuestri path
			Empleado empleadoConsultado = this.empleadoService.consultarEmpleadoPorNumeroEmpleado(numeroEmpleado);
			
			if(empleadoConsultado == null) {//Retoornar un objeto de tipo response
				return Response.noContent().build();
			}
			//en el caso que si lo encuentre indicamos
			GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleadoConsultado, Empleado.class);
			return Response.ok(empleadoGeneric).build();
	}
		
		
		//Pasamos un parametro
		//Ahora uno con el tipo RESPONSE
		//Agregamos ahora el probar con POST
			@POST
			@Path("guardarEmpleado")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON )
			public Response guardarEmpleado(Empleado empleado) {//Este valor debe hacer match en nuestri path
				
				if(empleado == null) {
					return Response.status(400).entity("No se ingreso informacion del empleado, favor de capturar datos").build();
				}
				if(empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
					return Response.status(400).entity("El nombre es requerido").build();
				}
				GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class);
				return Response.ok(empleadoGeneric).build();
		}
}
