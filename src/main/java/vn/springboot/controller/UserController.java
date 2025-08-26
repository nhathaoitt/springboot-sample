package vn.springboot.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import vn.springboot.dto.request.UserRequestDTO;
import vn.springboot.dto.response.ResponseData;
import vn.springboot.dto.response.ResponseError;
import vn.springboot.dto.response.ResponseSuccess;
import vn.springboot.service.UserService;
import vn.springboot.validation.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userDTO){
        try{
            userService.add(userDTO);
            return new ResponseData<>(HttpStatus.CREATED.value(), "user added successful");
        }catch (ResourceNotFoundException e) {
            return new ResponseError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }
    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable @Min(1) int userId, @Valid @RequestBody UserRequestDTO userDTO){
        System.out.println("update User success userid="+ userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "user updated successful");
    }
    @PatchMapping("{userId}")
    public ResponseData<?> changeStatus(@PathVariable int userId, @RequestParam(required = false) String status){
        System.out.println("change status success userid="+ userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "user changed successful");
    }
    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@PathVariable int userId){
        System.out.println("delete User success userid="+ userId);
        return new  ResponseData<>(HttpStatus.NO_CONTENT.value(), "user deleted successful");
    }
    @GetMapping("/{userId}")
    public ResponseData<?> getUser(@PathVariable int userId){
        System.out.println("getUser success userid="+ userId);
        return new ResponseData<>(HttpStatus.OK.value(), "user get successful", new UserRequestDTO("Mr", "Bin", "jjj@", "03333"));
    }
    @GetMapping("/list")
    public ResponseData<List<UserRequestDTO>> getUserList(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        System.out.println("getUserList success");
        return new ResponseData<>(HttpStatus.OK.value(), "user get successful",List.of(new UserRequestDTO("Mr", "Bin", "jjj@", "03333"),
                new UserRequestDTO("Mr", "Bin", "jjj@", "03333")));
    }
}
