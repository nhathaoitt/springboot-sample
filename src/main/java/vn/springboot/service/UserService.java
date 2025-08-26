package vn.springboot.service;

import vn.springboot.dto.request.UserRequestDTO;

public interface UserService {
    int add (UserRequestDTO userDTO);
}
