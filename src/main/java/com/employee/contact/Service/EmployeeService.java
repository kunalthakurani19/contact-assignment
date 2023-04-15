package com.employee.contact.Service;

import com.employee.contact.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployee(int pageNo, int pageSize);
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);

    void updateEmployee(Employee employee);
}
