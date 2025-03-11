package com.ems.fullstatck.serviceImpl;

import com.ems.fullstatck.entity.Employee;
import com.ems.fullstatck.entity.EmployeeDTO;
import com.ems.fullstatck.exception.EmployeeAlreadyExistException;
import com.ems.fullstatck.exception.EmployeeNotFoundException;
import com.ems.fullstatck.repository.EmployeeRespository;
import com.ems.fullstatck.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRespository employeeRespository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> isExistEmail = employeeRespository.findByEmail(employeeDTO.getEmail());
        if (isExistEmail.isPresent()) {
            throw new EmployeeAlreadyExistException("Email already exist " + employeeDTO.getEmail());
        } else {
            Employee employee = convertToEntity(employeeDTO);
            Employee savedEmployee = employeeRespository.save(employee);
            return convertToDTO(savedEmployee);
        }

    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employees = employeeRespository.findAll();
        return employees.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Long id) {

        Employee employee = employeeRespository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("EMPLOYEE NOT FOUND WITH ID - " + id));

        return convertToDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id,EmployeeDTO employeeDTO) {
        Employee employee = employeeRespository.findById(employeeDTO.getId()).orElseThrow(() -> new EmployeeNotFoundException("EMPLOYEE NOT FOUND WITH ID - " + employeeDTO.getId()));
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setCity(employeeDTO.getCity());

        Employee updatedEmployee = employeeRespository.save(employee);
        return convertToDTO(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee isExistId = employeeRespository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("EMPLOYEE NOT FOUND WITH ID " + id));
        employeeRespository.delete(isExistId);
    }

//    @Override
//    public Employee convertToEntity(EmployeeDTO employeeDTO) {
//
//        Employee employee = new Employee();
//        employee.setId(employeeDTO.getId());
//        employee.setName(employeeDTO.getName());
//        employee.setEmail(employeeDTO.getEmail());
//        employee.setCity(employeeDTO.getCity());
//        return employee;
//    }

    @Override
    public Employee convertToEntity(EmployeeDTO employeeDTO) {
        return Optional.ofNullable(employeeDTO)
                .map(dto -> new Employee(
                        dto.getId(),
                        dto.getName(),
                        dto.getEmail(),
                        dto.getCity()))
                .orElseThrow(() -> new IllegalArgumentException("EmployeeDTO cannot be null"));
    }

//    @Override
//    public EmployeeDTO convertToDTO(Employee employee) {
//        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail(), employee.getCity());
//    }

    public EmployeeDTO convertToDTO(Employee employee) {
        return Optional.ofNullable(employee)
                .map(emp -> new EmployeeDTO.Builder()
                        .id(emp.getId())
                        .name(emp.getName())
                        .email(emp.getEmail())
                        .city(emp.getCity())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("Employee cannot be null"));
    }


}
