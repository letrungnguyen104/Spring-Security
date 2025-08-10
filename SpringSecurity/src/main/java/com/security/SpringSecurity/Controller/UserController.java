package com.security.SpringSecurity.Controller;

import com.security.SpringSecurity.Dto.request.UserCreationRequest;
import com.security.SpringSecurity.Dto.request.UserUpdateRequest;
import com.security.SpringSecurity.Dto.response.ApiResponse;
import com.security.SpringSecurity.Dto.response.UserResponse;
import com.security.SpringSecurity.Entity.Users;
import com.security.SpringSecurity.Service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping("/regist")
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest){
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createRequest(userCreationRequest));
        return apiResponse;
    }

    @GetMapping("/list-user")
    List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/get-user/{userId}")
    UserResponse getUser(@PathVariable("userId") int userId){
        return userService.getUser(userId);
    }

    @PutMapping("/update/{userId}")
    UserResponse updateUser(@PathVariable int userId, @RequestBody UserUpdateRequest userUpdateRequest){
        return userService.updateUser(userId, userUpdateRequest);
    }

    @DeleteMapping("/delete/{userId}")
    void deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
    }
}
