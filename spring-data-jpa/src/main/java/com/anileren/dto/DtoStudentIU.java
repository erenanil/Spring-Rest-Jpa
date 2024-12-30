package com.anileren.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
    
    @Size(min = 3, max = 15)
    @NotEmpty(message = "Bu alan minimum 3 karakter maksimum 15 karakter araliginda olmalidir.")
    private String firstName;

    @Size(min = 3, max = 40)
    @NotEmpty(message = "Bu alan minimum 3 karakter maksimum 40 karakter araliginda olmalidir.")
    private String lastName;

    private Date birthOfDate;

}
