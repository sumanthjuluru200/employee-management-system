package com.ems.fullstatck.controller;


import com.ems.fullstatck.entity.Employee;
import com.ems.fullstatck.entity.EmployeeDTO;
import com.ems.fullstatck.repository.EmployeeRespository;
import com.ems.fullstatck.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
    }

    @GetMapping("/getAll")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
        return ResponseEntity.ok("EMPLOYEE UPDATE SUCCESSFULLY " + employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("EMPLOYEE DELTED SUCCESSFULLY WITH ID - " + id);
    }

}


