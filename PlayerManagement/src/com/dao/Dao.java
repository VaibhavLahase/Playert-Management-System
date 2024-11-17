package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class Dao {
String path = "com.mysql.cj.jdbc.Driver";
	    String pwd = "root@123";
	    String uname = "root";
	    String url = "jdbc:mysql://localhost:3306/company1";

	    Connection conn = null;
	    ResultSet rs = null;

	    public List<Employee> getAllEmployee() {
	        List<Employee> allemployeelist = new ArrayList<>();
	        String query = "SELECT * FROM employee";
	        PreparedStatement ps = null;

	        try {
	            Class.forName(path);
	            conn = DriverManager.getConnection(url, uname, pwd);
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Employee emp = new Employee();
	                emp.setId(rs.getInt("id"));
	                emp.setName(rs.getString("name"));
	                emp.setDept(rs.getString("dept"));
	                emp.setSalary(rs.getInt("salary"));
	                emp.setHiringDate(rs.getInt("hiringDate"));
	                emp.setAddress(rs.getString("address"));
	                allemployeelist.add(emp);
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return allemployeelist;
	    }

	    
	    public void insertEmployee(Employee emp) {
	    	String insertQuery = "INSERT INTO company1.employee (id, name, dept, salary, hiringDate, address) VALUES (?, ?, ?, ?, ?, ?)";
	    	PreparedStatement ps = null;
	    	
	    	try {
				Class.forName(path);
				conn = DriverManager.getConnection(url, uname, pwd);

				ps = conn.prepareStatement(insertQuery);
				ps.setInt(1, emp.getId());
				ps.setString(2, emp.getName());
				ps.setString(3, emp.getDept());
				ps.setInt(4, emp.getSalary());
				ps.setInt(5, emp.getHiringDate());
				ps.setString(6, emp.getAddress());

				ps.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null) ps.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	    
	    
	    public boolean updateEmployee(Employee emp) {
	        String query = "UPDATE employee SET name = ?, dept = ?, salary = ?, hiringDate = ?, address = ? WHERE id = ?";
	        PreparedStatement ps = null;
	        boolean isUpdated = false;

	        try {
	            conn = DriverManager.getConnection(url, uname, pwd);

	            ps = conn.prepareStatement("SELECT COUNT(*) FROM employee WHERE id = ?");
	            ps.setInt(1, emp.getId());
	            rs = ps.executeQuery();

	            if (rs.next() && rs.getInt(1) == 0) {
	                System.out.println("Employee with ID " + emp.getId() + " not found.");
	                return false;
	            }

	            ps = conn.prepareStatement(query);
	            ps.setString(1, emp.getName());
	            ps.setString(2, emp.getDept());
	            ps.setInt(3, emp.getSalary());
	            ps.setInt(4, emp.getHiringDate());
	            ps.setString(5, emp.getAddress());
	            ps.setInt(6, emp.getId());

	            int rowsAffected = ps.executeUpdate();
	            if (rowsAffected > 0) {
	                isUpdated = true;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return isUpdated;
	    }

	    public boolean deleteEmployee(int id) {
	        String deleteQuery = "DELETE FROM employee WHERE id = ?";
	        PreparedStatement ps = null;
	        boolean isDeleted = false;

	        try {
	            conn = DriverManager.getConnection(url, uname, pwd);

	            ps = conn.prepareStatement("SELECT COUNT(*) FROM employee WHERE id = ?");
	            ps.setInt(1, id);
	            rs = ps.executeQuery();

	            if (rs.next() && rs.getInt(1) == 0) {
	                System.out.println("Employee with ID " + id + " not found.");
	                return false;
	            }

	            ps = conn.prepareStatement(deleteQuery);
	            ps.setInt(1, id);

	            int rowsAffected = ps.executeUpdate();
	            if (rowsAffected > 0) {
	                isDeleted = true;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return isDeleted;
	    }
}
