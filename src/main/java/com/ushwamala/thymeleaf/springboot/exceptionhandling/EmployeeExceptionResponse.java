package com.ushwamala.thymeleaf.springboot.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeExceptionResponse {

    private int status;

    private String message;

    private long timeStamp;
}
