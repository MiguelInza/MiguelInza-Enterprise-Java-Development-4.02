package com.miguel.lab42.service.interfaces;


import com.miguel.lab42.model.Employee;
import com.miguel.lab42.controller.dto.EmployeeStatusDTO;

public interface EmployeeService {

    void updateEmployeesStatus(Integer id, EmployeeStatusDTO employeeStatusDTO);
    void updateDepartment(String department, Employee employee);
}
