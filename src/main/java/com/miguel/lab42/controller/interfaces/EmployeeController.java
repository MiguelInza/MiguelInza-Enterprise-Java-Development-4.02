package com.miguel.lab42.controller.interfaces;

import com.miguel.lab42.controller.dto.EmployeeStatusDTO;
import com.miguel.lab42.enums.EmployeeStatus;
import com.miguel.lab42.model.Employee;

import java.util.List;

public interface EmployeeController {
    List<Employee> findAll();

    Employee findById(Integer id);

    List<Employee> findByStatus(EmployeeStatus status);

    Employee addNewEmployee(Employee employee);
    void addAnotherEmployee(Employee employee);

    void updateEmployeesStatus(Integer id,/* Enum status,*/ EmployeeStatusDTO employeeStatusDTO);

    void updateDepartment(String department, Employee employee);

}

/*
Create a route to change a doctor’s status.
*/