package jtechlog.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {

    @Query("select new jtechlog.employees.EmployeeResource(e.id, e.name) from Employee e")
    List<EmployeeResource> findAllResources();
}
