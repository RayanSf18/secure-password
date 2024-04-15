package com.raya.dev.securitypassword.controller;

import com.raya.dev.securitypassword.domain.dto.FailureResponse;
import com.raya.dev.securitypassword.domain.dto.PasswordRequest;
import com.raya.dev.securitypassword.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody PasswordRequest request) {
        var failures = passwordService.validatePass(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }
}
