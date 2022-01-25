package nvc.bcit.soi5shopstart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.bcit.soi5shopstart.model.Employee;
import nvc.bcit.soi5shopstart.repository.EmployeeRepository;



@Service
public class EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;

  public List<Employee> findAll(){
        return employeeRepository.findAll();
  }

  public Employee getById(int id){
      return employeeRepository.getById(id);
  }

  public List<Employee> findByName(String name){
    return employeeRepository.findByNameContaining(name);
  }

  public List<Employee> findBySalary(int salary){
    return employeeRepository.findBySalaryGreaterThan(salary);
  }
   
  public Employee save(Employee employee){
    return employeeRepository.save(employee);
  }

  public void delete(Employee employee){
    employeeRepository.delete(employee);
  }
}
