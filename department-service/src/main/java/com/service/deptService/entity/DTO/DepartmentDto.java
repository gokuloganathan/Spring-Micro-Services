package com.service.deptService.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
	private Long id;
	
	private String deptName;
	
	private String deptAddress;
	
	private String deptCode;
}
