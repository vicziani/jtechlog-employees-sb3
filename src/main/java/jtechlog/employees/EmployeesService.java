package jtechlog.employees;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    private EmployeesRepository repository;

    public List<EmployeeResource> listEmployees() {
        return repository.findAllResources();
    }

    public EmployeeResource findEmployeeById(long id) {
        return toDto(repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee not found")));
    }

    public EmployeeResource createEmployee(EmployeeResource command) {
        Employee employee = new Employee(command.getName());
        repository.save(employee);
        return toDto(employee);
    }

    public EmployeeResource updateEmployee(long id, EmployeeResource command) {
        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("employee not found"));
        employee.setName(command.getName());
        return toDto(employee);
    }

    public void deleteEmployee(long id) {
        repository.deleteById(id);
    }

    private EmployeeResource toDto(Employee employee) {
        return new EmployeeResource(employee.getId(), employee.getName());
    }

}
