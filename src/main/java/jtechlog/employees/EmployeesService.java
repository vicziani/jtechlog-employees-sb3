package jtechlog.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    private EmployeeMapper employeeMapper;

    private EmployeesRepository repository;

    public List<EmployeeDto> listEmployees() {
        return employeeMapper.toDto(repository.findAll());
    }

    public EmployeeDto findEmployeeById(long id) {
        return employeeMapper.toDto(repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee not found")));
    }

    public EmployeeDto createEmployee(CreateEmployeeCommand command) {
        Employee employee = new Employee(command.getName());
        repository.save(employee);
        return employeeMapper.toDto(employee);
    }

    public EmployeeDto updateEmployee(long id, UpdateEmployeeCommand command) {
        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee not found"));
        employee.setName(command.getName());
        return employeeMapper.toDto(employee);
    }

    public void deleteEmployee(long id) {
        repository.deleteById(id);
    }
}
