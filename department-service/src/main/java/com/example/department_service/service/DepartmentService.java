package com.example.department_service.service;

import com.example.department_service.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}
