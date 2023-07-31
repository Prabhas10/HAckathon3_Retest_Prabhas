package com.hackathon.hackathon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Employee already exists")
public class EmployeeAlreadyExistsException extends RuntimeException {
}