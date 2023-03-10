package com.miguel.lab42.controller.impl;

import com.miguel.lab42.controller.interfaces.PatientController;
import com.miguel.lab42.enums.EmployeeStatus;
import com.miguel.lab42.model.Patient;
import com.miguel.lab42.repository.PatientRepository;
import com.miguel.lab42.service.interfaces.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientControllerImpl implements PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient findById(@PathVariable(name = "id") Integer id) {
        return patientRepository.findById(id).get();
    }

    @GetMapping("/patients/dob")
    public List<Patient> getByDateOfBirthBetween(@RequestParam LocalDate from,@RequestParam LocalDate to) {
        return patientRepository.findByBirthdayBetween(from, to);
    }

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addNewPatient(@RequestBody @Valid Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/patients/admittedByDepartment/{department}")
    public List<Patient> getByAdmittedByDepartment(@PathVariable(name = "department") String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patients/admittedByStatusOFF")
    public List<Patient> getByAdmittedByEmployeeStatus() {
        return patientRepository.findByAdmittedByEmployeeStatus(EmployeeStatus.OFF);
    }

    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatientsInformation(@PathVariable Integer id, @RequestBody @Valid Patient patient) {
        patientService.updatePatientsInformation(id, patient);
    }



}
