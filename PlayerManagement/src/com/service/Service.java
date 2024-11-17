package com.service;

import java.util.List;

import com.dao.Dao;
import com.entity.Employee;

public class Service {
Dao dao = null;

	public List<Employee> getAllEmployee() {
		dao = new Dao();

		List<Employee> allEmployee = dao.getAllEmployee();
		return allEmployee;

	}

	public void insertEmployee(Employee emp) {
		dao = new Dao();
		dao.insertEmployee(emp);
	}

	// New method to delete an employee by ID
	public boolean updateEmployee(Employee emp) {
        dao = new Dao();
        return dao.updateEmployee(emp);
    }

    public boolean deleteEmployee(int id) {
        dao = new Dao();
        return dao.deleteEmployee(id);
    }
}
