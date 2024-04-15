package com.raya.dev.securitypassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public List<String> validatePass(String password) {
        List<String> failures = new ArrayList<>();

        validateLength(password, failures);

        validateUpperCase(password, failures);

        validateLowerCase(password, failures);

        validateDigit(password, failures);

        validateSymbol(password, failures);

        return failures;
    }

    private void validateLength(String password, List<String> failures) {

        if (password != null && password.length() < 8) {
            failures.add("The password must have at least 8 characters.");
        }
    }

    private void validateUpperCase(String password, List<String> failures) {

        if (!password.matches(".*[A-Z].*")) {
            failures.add("The password must have at least one capital letter.");
        }

    }

    private void validateLowerCase(String password, List<String> failures) {

        if (!password.matches(".*[a-z].*")) {
            failures.add("The password must have at least one lowercase letter.");
        }

    }

    private void validateDigit(String password, List<String> failures) {

        if (!password.matches(".*[0-9].*")) {
            failures.add("The password must have at least one numeric digit.");
        }

    }

    private void validateSymbol(String password, List<String> failures) {

        if (!password.matches(".*[\\W].*")) {
            failures.add("The password must have at least one special character (e.g., !@#$%).");
        }

    }

}
