package com.controller;

import java.util.List;

import com.entity.Employee;
import com.service.Service;

public class EmpContoller {
Service service = null;
	
	public List<Employee> getAllEmployee() {

		service = new Service();
		List<Employee> allEmployee = service.getAllEmployee();

		return allEmployee;

	}
	
	public void insertEmployee(Employee emp) {
		service = new Service();
		service.insertEmployee(emp);
	}
	
	public boolean updateEmployee(Employee emp) {
        service = new Service();
        return service.updateEmployee(emp);
    }

    public boolean deleteEmployee(int id) {
        service = new Service();
        return service.deleteEmployee(id);
    }
}
