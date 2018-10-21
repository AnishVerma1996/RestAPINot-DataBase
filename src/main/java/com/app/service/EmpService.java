package com.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Employee;
@Service
public class EmpService 
{
	List<Employee> emplist=new ArrayList();
	
	
public boolean saveEmp(Employee e)
{
	boolean b=false;
	try
	{
	emplist.add(e);
	b=true;
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	return b;
}
public List<Employee> getEmp()
{
	return emplist;
}
public boolean updateEmp(Employee e)
{
	boolean b=false;
	Employee upObj=null;
	Employee delObj=null;
	try
	{
		
		for(Employee e1:emplist)
		{
			if(e1.getEid()==e.getEid())
			{
				upObj=e;
				delObj=e1;
				b=true;
			}
		}
		emplist.add(upObj);
		emplist.remove(delObj);
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	return b;
}
public boolean delete(int eid)
{
	boolean b=false;
	Employee delObj=null;
	try
	{
		for(Employee e:emplist)
		{
		if(eid==e.getEid())
		{
          delObj=e;
        //  System.out.println(e);
          b=true;
		}
		}
		
		//System.out.println(delObj);
		emplist.remove(delObj);
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	return b;
}
}
