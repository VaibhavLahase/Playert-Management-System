package com.entity;

public class Employee{
    int id;
	String name;
	String dept;
	int salary;
	int hiringDate;
	String address;

	public Employee(int id, String name, String dept, int salary, int hiringDate, String address) {
    super();
    this.id = id;
    this.name = name;
    this.dept = dept;
    this.salary = salary;
    this.hiringDate = hiringDate;
    this.address = address;
}

public Employee() {
    // TODO Auto-generated constructor stub
    super();
}

public Integer getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDept() {
    return dept;
}

public void setDept(String dept) {
    this.dept = dept;
}

public Integer getSalary() {
    return salary;
}

public void setSalary(int salary) {
    this.salary = salary;
}

public Integer getHiringDate() {
    return hiringDate;
}

public void setHiringDate(int hiringDate) {
    this.hiringDate = hiringDate;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

@Override
public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", hiringDate="
            + hiringDate + ", address=" + address + "]";
}

}
