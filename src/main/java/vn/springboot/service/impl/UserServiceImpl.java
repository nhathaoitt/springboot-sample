package vn.springboot.service.impl;

import org.springframework.stereotype.Service;
import vn.springboot.dto.request.UserRequestDTO;
import vn.springboot.service.UserService;
import vn.springboot.validation.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int add(UserRequestDTO userDTO) {
        if (!userDTO.getFirstName().equals("haoIT")) {
            throw new ResourceNotFoundException("save failed");
        }
        return 1;
    }
}
