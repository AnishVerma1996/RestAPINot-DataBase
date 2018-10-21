package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmpService;

@RestController
public class EmpController 
{
@Autowired
private EmpService es;
@GetMapping(value="/List",produces="application/json")
public List<Employee> allEmp()
{
	List<Employee> list=es.getEmp();
	return list;
}
@PostMapping(value="/SaveEmp")
public String addEmp(@RequestBody Employee e)
{
	Boolean b=es.saveEmp(e);
	if(b)
	{
		return "SuccessFull Added";
	}
	else
	{
		return "Failed";
	}
}
@DeleteMapping("/delete/{eid}")
public String delEmp(@PathVariable int eid)
{
	Boolean b=es.delete(eid);
	if(b)
	{
		return "SuccessFull Deleted";
	}
	else
	{
		return "Failed";
	}
}
@PutMapping("/updateemp")
public List<Employee> upEmp(@RequestBody Employee e)
{
	
	Boolean b=es.updateEmp(e);
	List<Employee> list=allEmp();
	return list;
}
}
