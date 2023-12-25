package com.service.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.user.Entity.User;
import com.service.user.Entity.Dto.DepartmentDto;
import com.service.user.Entity.Dto.ResponseDto;
import com.service.user.Entity.Dto.UserDto;
import com.service.user.Repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseDto getUser(Long userId) {
		ResponseDto responseDto = new ResponseDto();
		User user = userRepository.findById(userId).get();
		UserDto userDto = UserDto.builder().id(user.getId()).firstName(user.getFirstName()).lastName(user.getLastName()).email(user.getEmail()).build();
		
		ResponseEntity<DepartmentDto> responseEntity = restTemplate
				.getForEntity("http://DEPARTMENT-SERVICE/api/departments/"+user.getDepartmentId(),DepartmentDto.class);
		
		DepartmentDto departmentDto = responseEntity.getBody();
		log.info("department response status : "+responseEntity.getStatusCode());
		
		responseDto.setUser(userDto);
		responseDto.setDepartment(departmentDto);
		
		
		return responseDto;
	}	
}
