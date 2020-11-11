package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class EmployeeDTO {
    private int id;
    private String code;
    private String username;
    private String password;
    private String name;
    private LocalDate birthday;
    private String email;
    private byte gender;
    private String cardId;
    private String nameRole;
}
