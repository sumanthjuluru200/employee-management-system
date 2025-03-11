package com.ems.fullstatck.controller;

import com.ems.fullstatck.entity.EmployeeDTO;
import com.ems.fullstatck.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;


    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> saveEmp(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);

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
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "EMPLOYEE DELETED SUCCESSFULLY");
        response.put("id", id);
        response.put("status", HttpStatus.OK.value());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}


