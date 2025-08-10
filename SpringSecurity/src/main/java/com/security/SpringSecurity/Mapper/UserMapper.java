package com.security.SpringSecurity.Mapper;

import com.security.SpringSecurity.Dto.request.UserCreationRequest;
import com.security.SpringSecurity.Dto.request.UserUpdateRequest;
import com.security.SpringSecurity.Dto.response.UserResponse;
import com.security.SpringSecurity.Entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUser(UserCreationRequest userCreationRequest);
    List<UserResponse> toUserResponses(List<Users> listUser);
    UserResponse toUserResponse(Users users);
    //Mapping data từ UserUpdateRequest sang Users
    void updateUser(@MappingTarget Users users, UserUpdateRequest userUpdateRequest);
}
