package com.security.SpringSecurity.Controller;

import com.security.SpringSecurity.Dto.request.AuthenticationRequest;
import com.security.SpringSecurity.Dto.response.ApiResponse;
import com.security.SpringSecurity.Dto.response.AuthenticationResponse;
import com.security.SpringSecurity.Service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        boolean result = authenticationService.authenticated(authenticationRequest);
        //ApiResponse apiResponse = new ApiResponse();
        //apiResponse.setResult(result);
        //Thay vì dùng như trên thì dùng Builder để set data cho ApiResponse
        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }
}
