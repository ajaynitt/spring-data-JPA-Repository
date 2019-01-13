package com.love2code.springboot.cruddemo.service;

import com.love2code.springboot.cruddemo.dao.EmployeeRepository;
import com.love2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    //employeeDAOJPAImpl - name of iml calss starting with  lowercase
    public EmployeeServiceImpl(/*@Qualifier("employeeDAOJPAImpl")*/ EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    //@Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    //@Transactional
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (!result.isPresent()) {
            throw new RuntimeException("couldnot find an employee with id " + id);
        }
        return result.get();

    }

    @Override
    //@Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    //@Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }
}
