package com.miguel.lab42.controller.impl;

import com.miguel.lab42.controller.interfaces.EmployeeController;
import com.miguel.lab42.controller.dto.EmployeeStatusDTO;
import com.miguel.lab42.enums.EmployeeStatus;
import com.miguel.lab42.model.Employee;
import com.miguel.lab42.repository.EmployeeRepository;
import com.miguel.lab42.service.interfaces.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeerService;



    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable(name = "id") Integer id) {
        return employeeRepository.findById(id).get();
    }

    @GetMapping("/employees/status/{status}")
    public List<Employee> findByStatus(@PathVariable("status")EmployeeStatus status){
        return employeeRepository.findByEmployeeStatus(status);
    }

    @PostMapping("employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addNewEmployee(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    @PostMapping("employee-add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnotherEmployee(@RequestBody @Valid Employee employee) {
        employeeRepository.save(employee);
//        employeerService.save(employee);

    }

   /* @Override
    public void updateEmployeesStatus(Integer id, Enum status, EmployeeStatusDTO employeeStatusDTO) {

    }*/

    @PatchMapping("/employees/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeesStatus(@PathVariable Integer id, @RequestBody @Valid EmployeeStatusDTO employeeStatusDTO) {

        employeerService.updateEmployeesStatus(id, employeeStatusDTO);
    }

    @PutMapping("/employees/department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartment(@PathVariable String id, @RequestBody @Valid Employee employee) {
        employeerService.updateDepartment(id, employee);
    }


}
