package com.security.SpringSecurity.Service;

import com.security.SpringSecurity.Dto.request.UserCreationRequest;
import com.security.SpringSecurity.Dto.request.UserUpdateRequest;
import com.security.SpringSecurity.Dto.response.UserResponse;
import com.security.SpringSecurity.Entity.Users;
import com.security.SpringSecurity.Exception.AppException;
import com.security.SpringSecurity.Exception.ErrorCode;
import com.security.SpringSecurity.Mapper.UserMapper;
import com.security.SpringSecurity.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) //Thay thế Autowired
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createRequest(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        Users user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<UserResponse> getUsers(){
        return userMapper.toUserResponses(userRepository.findAll());
    }

    public UserResponse getUser(int userId){
        return userMapper.toUserResponse(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!")));
    }

    public UserResponse updateUser(int userId, UserUpdateRequest userUpdateRequest){
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));
        userMapper.updateUser(user, userUpdateRequest);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(int userId){

        userRepository.deleteById(userId);
    }
}
