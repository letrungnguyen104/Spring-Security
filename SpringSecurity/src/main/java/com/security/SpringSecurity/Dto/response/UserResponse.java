package com.security.SpringSecurity.Dto.response;

import com.security.SpringSecurity.Entity.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    int id;
    String fullname;
    String email;
    private String username;
    String password;
    Roles roles;
}
