package com.service.deptService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.deptService.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
