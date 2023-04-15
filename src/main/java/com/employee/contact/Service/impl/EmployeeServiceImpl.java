package com.employee.contact.Service.impl;

import com.employee.contact.Model.Employee;
import com.employee.contact.Repo.EmployeeRepository;
import com.employee.contact.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployee(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Employee> pageResult = employeeRepository.findAll((org.springframework.data.domain.Pageable) paging);
        return pageResult.getContent();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId())
                .orElse(null);
        existingEmployee.setFirstname(employee.getFirstname());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setContacts(employee.getContacts());
        employeeRepository.save(existingEmployee);
    }
}
