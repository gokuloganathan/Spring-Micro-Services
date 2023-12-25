package com.service.deptService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.deptService.Repository.DepartmentRepository;
import com.service.deptService.entity.Department;
import com.service.deptService.entity.DTO.DepartmentDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository deptRepository;

	@Override
	public DepartmentDto saveDepartment(Department department) {
		Department departmentSaved = deptRepository.save(department);
		return DepartmentDto.builder()
				.id(departmentSaved.getId())
				.deptName(departmentSaved.getDepartmentName())
				.deptAddress(departmentSaved.getDepartmentAddress())
				.deptCode(departmentSaved.getDepartmentCode())
				.build();
	}

	@Override
	public DepartmentDto getDepartmentById(Long deptId) {
		Department department = deptRepository.findById(deptId).get();
		return DepartmentDto.builder()
				.id(department.getId())
				.deptName(department.getDepartmentAddress())
				.deptCode(department.getDepartmentCode())
				.deptAddress(department.getDepartmentAddress())
				.build();
	}

}
