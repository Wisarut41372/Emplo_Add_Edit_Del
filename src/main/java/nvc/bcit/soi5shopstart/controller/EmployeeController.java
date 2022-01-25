package nvc.bcit.soi5shopstart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nvc.bcit.soi5shopstart.model.Department;
import nvc.bcit.soi5shopstart.model.Employee;
import nvc.bcit.soi5shopstart.model.Projectt;
import nvc.bcit.soi5shopstart.repository.DepartmentRepository;
import nvc.bcit.soi5shopstart.repository.ProjectRepository;
import nvc.bcit.soi5shopstart.service.EmployeeService;

    @Controller
    @RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("")
    public ModelAndView employee() {
        List<Employee> employees = employeeService.findAll();
        return new ModelAndView("employee","employees",employees);
    }

    @GetMapping("/new")
    public String newEmployee (ModelMap modelMap) {
        Employee employee = new Employee();
        modelMap.addAttribute("employee", employee);
        return "newemployee";
    }

    @GetMapping("/edit")
    public String editEmployee () {
        return "editemployee";
    }
    //ค้นหาชื่อ
    @GetMapping("/name/{name}")
    public ModelAndView getEmployeeByName(@PathVariable("name")String name){
        List<Employee> employees = employeeService.findByName(name);
        return new ModelAndView("employee","employees",employees);
    }
//ค้นหาเงินเดือน
    @GetMapping("/salary/{salary}")
    public ModelAndView getEmployeeByName(@PathVariable("salary")int salary){
        List<Employee> employees = employeeService.findBySalary(salary);
        return new ModelAndView("employee","employees",employees);
    }

    @ModelAttribute("departments")
    public List<Department> lodeDepartments(){
    List<Department> departments = departmentRepository.findAll();
    return departments;
    }   

    @ModelAttribute("projects")
    public List<Projectt> lodeProjects(){
    List<Projectt> projectts = projectRepository.findAll();
    return projectts;
    }

    @PostMapping("/add")
    public String saveEmployee(Employee employee,BindingResult result){
    if(result.hasErrors()){
        return "newemployee";
    }else{
        employeeService.save(employee);
        return "redirect:/employee";
    }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
       Employee employee = employeeService.getById(id);
       employeeService.delete(employee);
       return new ModelAndView("redirect:/employee");
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id , ModelMap modelMap){
        Employee employee = employeeService.getById(id);
        modelMap.addAttribute("employee", employee);
        return "editemployee";
    }

    
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, BindingResult result){
        if(result.hasErrors()){
            return "editemployee";
        }else{
            Employee eplo = employeeService.getById(employee.getId());
            eplo.setName(employee.getName());
            eplo.setSalary(employee.getSalary());
            eplo.setProjectt(employee.getProjectt());
            eplo.setDepartment(employee.getDepartment());
            employeeService.save(eplo);
            return "redirect:/employee";
        }
    }
}