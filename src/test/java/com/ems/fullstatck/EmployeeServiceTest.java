package com.ems.fullstatck;

import com.ems.fullstatck.entity.Employee;
import com.ems.fullstatck.entity.EmployeeDTO;
import com.ems.fullstatck.repository.EmployeeRespository;
import com.ems.fullstatck.serviceImpl.EmployeeServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRespository employeeRespository;

    @InjectMocks
    private EmployeeServiceImp employeeServiceImp;

    private Employee employee;
    private EmployeeDTO employeeDTO;

    @BeforeEach
    public void setup() {
        employee = new Employee(1L, "Sai", "sai@gmail.com", "Raidurgam");
//        employeeDTO = new EmployeeDTO(1L, "Sai", "sai@gmail.com", "Raidurgam");
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id(1L)
                .name("John Doe")
                .email("john.doe@example.com")
                .city("New York")
                .build();
    }

    @Test
    public void testGetAllEmployees() {
        when(employeeRespository.findAll()).thenReturn(Arrays.asList(employee));
        List<EmployeeDTO> employeeDTOS = employeeServiceImp.findAllEmployees();
        assertNotNull(employeeDTOS);
        assertEquals(1, employeeDTOS.size());
    }

    @DisplayName("Get Employee By Id Test Method")
    @Test
    public void testGetEmployeeById() {

        when(employeeRespository.findById(anyLong())).thenReturn(Optional.of(employee));
        EmployeeDTO foundEmployee = employeeServiceImp.findById(1L);
        assertNotNull(foundEmployee);
        assertEquals(employee.getName(), foundEmployee.getName());
    }


    @Test
    @DisplayName("Save Employee Test")
    public void testSaveEmployee() {
//        when(employeeRespository.findByEmail(any(String.class))).thenReturn(Optional.empty());
        when(employeeRespository.save(any(Employee.class))).thenReturn(employee);
        EmployeeDTO savedEmployee = employeeServiceImp.saveEmployee(employeeDTO);
        assertNotNull(savedEmployee);
        assertEquals(employeeDTO.getName(), savedEmployee.getName());
    }

    @Test
    @DisplayName("Update Employee Test")
    public void testUpdateEmployee() {
        when(employeeRespository.findById(anyLong())).thenReturn(Optional.of(employee));
        when(employeeRespository.save(any(Employee.class))).thenReturn(employee);
        EmployeeDTO updatedEmployee = employeeServiceImp.saveEmployee(employeeDTO);
        assertNotNull(updatedEmployee);
        assertEquals(employeeDTO.getName(), updatedEmployee.getName());

    }

    @Test
    @DisplayName("Delete Employee Test")
    public void testDeleteEmployee() {
        when(employeeRespository.findById(anyLong())).thenReturn(Optional.of(employee));
        employeeServiceImp.deleteEmployee(1L);

        verify(employeeRespository, times(1)).findById(1L);
        verify(employeeRespository, times(1)).delete(employee);
    }
}
