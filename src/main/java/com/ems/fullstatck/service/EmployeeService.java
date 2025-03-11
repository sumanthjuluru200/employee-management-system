package com.ems.fullstatck.service;

import com.ems.fullstatck.EmsFullstackApplication;
import com.ems.fullstatck.entity.Employee;
import com.ems.fullstatck.entity.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> findAllEmployees();

    public EmployeeDTO findById(Long id);

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    public void deleteEmployee(Long id);

    public Employee convertToEntity(EmployeeDTO employeeDTO);

    EmployeeDTO convertToDTO(Employee employee);

}
