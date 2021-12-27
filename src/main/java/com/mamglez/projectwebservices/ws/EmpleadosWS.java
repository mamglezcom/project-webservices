package com.mamglez.projectwebservices.ws;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mamglez.projectwebservices.entity.Empleado;
import com.mamglez.projectwebservices.service.EmpleadoService;

@Path(value = "empleadosWS")
public class EmpleadosWS {
	
	private EmpleadoService empleadoService = new EmpleadoService();
	
	@Path("test")
	@GET
	public String test() {
		return "probando webservice";
	}
	
	@GET
	@Path(value = "consultarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleado() {
		return this.empleadoService.consultarEmpleado();
	}
	
	@GET
	@Path(value = "consultarEmpleados")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> consultarEmpleados(){
		
		return this.empleadoService.consultarEmpleados();
		
	}

	@GET
	@Path(value = "consultarEmpleadoPorNumero/{numeroEmpleado}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorId(@PathParam("numeroEmpleado") String numeroEmpleado) {
		
		Empleado empleado = this.empleadoService.consultarEmpleadoPorNumero(numeroEmpleado);
		
		if(empleado == null) {
			return Response.noContent().build();
		}
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
		
	}
	
	@POST
	@Path(value = "guardarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado emp) {
		
		if(emp == null) {
			return Response.status(400).entity("no se ingreso info del empleado").build();
		}
		if(emp.getNombre() == null || emp.getNombre().isEmpty()) {
			return Response.status(400).entity("el nombre es requerido").build();
		}
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(emp, Empleado.class);
		return Response.ok(empleadoGeneric).build();
		
	}
}
