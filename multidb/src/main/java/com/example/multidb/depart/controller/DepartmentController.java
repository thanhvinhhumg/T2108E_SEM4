package com.example.multidb.depart.controller;

import com.example.multidb.depart.entity.Department;
import com.example.multidb.depart.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;

    @PostMapping("create")
    public void createDepartment(@RequestBody Department department) {
        repository.save(department);
    }
}
