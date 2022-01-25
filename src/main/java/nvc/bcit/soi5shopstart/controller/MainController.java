package nvc.bcit.soi5shopstart.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

import nvc.bcit.soi5shopstart.model.Department;

import nvc.bcit.soi5shopstart.model.Projectt;
import nvc.bcit.soi5shopstart.repository.DepartmentRepository;

import nvc.bcit.soi5shopstart.repository.ProjectRepository;
import nvc.bcit.soi5shopstart.service.EmployeeService;





@Controller
public class MainController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProjectRepository projectRepository;
    
    @GetMapping("/")
    public String index () {
        return "index";
    }
    
    

    @GetMapping("/department/employee")
    public ModelAndView getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return new ModelAndView("department","departments",departments);
    }

    @GetMapping("/project/employee")
    public ModelAndView getProject(){
        List<Projectt> projectts = projectRepository.findAll();
        return new ModelAndView("project","projectts",projectts);
    }



}
