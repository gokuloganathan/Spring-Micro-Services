package com.service.deptService.Service;

import com.service.deptService.entity.Department;
import com.service.deptService.entity.DTO.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(Department department);
	
	DepartmentDto getDepartmentById(Long departmentId);
}
