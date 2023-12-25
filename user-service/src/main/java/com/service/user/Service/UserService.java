package com.service.user.Service;

import com.service.user.Entity.User;
import com.service.user.Entity.Dto.ResponseDto;

public interface UserService {
	User saveUser(User user);

    ResponseDto getUser(Long userId);
}
