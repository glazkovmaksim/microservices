package com.example.department_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="departments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
