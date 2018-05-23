package com.main.application;


import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import com.test.beans.Address;
import com.test.beans.Employee;

@Path("/new")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestController {
	private Datastore datastore = null;

	public RestController(Datastore datastore) {	
			this.datastore = datastore;
	}

	
	@GET
	public String getList(){
		datastore.save(new Test("yo"));
		return "Success";
	}
	
	@GET
	@Path("/employee/{name}")
	public List<Employee> getEmployee(@PathParam("name") String name){
		System.out.println("Name "+name);		
	return datastore.createQuery(Employee.class).
				field("name").equal(name).asList();
			
}
	
	@POST
	@Path("/employee")
	public Employee saveEmployee(@Valid Employee employee){
		System.out.println("Employee is "+employee);
		datastore.save(employee);
		return employee;
		
	}
	
	@POST
	@Path("reference/employee")
	public Employee saveEmployeeInDiffCollections(@Valid Employee employee){
		System.out.println("Employee is "+employee);
		datastore.save(employee.getAddress());
		datastore.save(employee);
		return employee;
	}
	
	@GET
	@Path("employee/address/{Id}")
	public Address getAddressOnEmployee(@PathParam("Id") String id){
		return datastore.createQuery(Employee.class).field("address").equal(id).get().getAddress();
	}
	
	@DELETE
	@Path("/employee/{name}")
	public int deleteEmployee(@PathParam("name") String name){
		Query<Employee> query = datastore.createQuery(Employee.class).filter("name =", name);
		return datastore.delete(query).getN();
	}
	
	@PUT
	@Path("/employee/{name1}/{name2}")
	public int updateEmployeeName(@PathParam("name1") String name1,@PathParam("name2") String name2){
		Query<Employee> query = datastore.createQuery(Employee.class).filter("name =", name1);
		UpdateOperations<Employee> updateEmployee =  datastore.createUpdateOperations(Employee.class).set("name", name2).set("designation","Chief");
		return datastore.update(query, updateEmployee).getUpdatedCount();
	}
}
