package com.security.SpringSecurity.Controller;

import com.nimbusds.jose.JOSEException;
import com.security.SpringSecurity.Dto.request.AuthenticationRequest;
import com.security.SpringSecurity.Dto.request.IntrospectRequest;
import com.security.SpringSecurity.Dto.response.ApiResponse;
import com.security.SpringSecurity.Dto.response.AuthenticationResponse;
import com.security.SpringSecurity.Dto.response.IntrospectResponse;
import com.security.SpringSecurity.Service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        var result = authenticationService.authenticated(authenticationRequest);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest introspectRequest)
            throws ParseException, JOSEException {
        IntrospectResponse result = authenticationService.introspect(introspectRequest);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
