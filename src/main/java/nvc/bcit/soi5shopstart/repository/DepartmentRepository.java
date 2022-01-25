package nvc.bcit.soi5shopstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.bcit.soi5shopstart.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
}
