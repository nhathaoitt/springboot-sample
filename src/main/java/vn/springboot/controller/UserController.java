package vn.springboot.controller;

import org.springframework.web.bind.annotation.*;
import vn.springboot.dto.request.UserRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/")
    public String addUser(@RequestBody UserRequestDTO userDTO){
        return "add User success";
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO){
        System.out.println("update User success userid="+ userId);
        return "update User success";
    }
    @PatchMapping("{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) String status){
        System.out.println("change status success userid="+ userId);
        return "update status success";
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
        System.out.println("delete User success userid="+ userId);
        return "delete User success";
    }
    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId){
        System.out.println("getUser success userid="+ userId);
        return new UserRequestDTO("Mr", "Bin", "jjj@", "03333");
    }
    @GetMapping("/list")
    public List<UserRequestDTO> getUserList(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        System.out.println("getUserList success");
        return List.of(new UserRequestDTO("Mr", "Bin", "jjj@", "03333"),
                        new UserRequestDTO("Mr", "Bin", "jjj@", "03333"));
    }
}
