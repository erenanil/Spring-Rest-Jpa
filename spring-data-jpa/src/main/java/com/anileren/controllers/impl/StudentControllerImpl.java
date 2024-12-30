package com.anileren.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anileren.controllers.IStudentController;
import com.anileren.dto.DtoStudent;
import com.anileren.dto.DtoStudentIU;
import com.anileren.services.IStudentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentControllerImpl implements IStudentController{


    @Autowired
    private IStudentService studentService;





    @Override
    @PostMapping(path = "/save")
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU DtoStudentIU) {
        return studentService.saveStudent(DtoStudentIU);
    }
    



    @Override
    @GetMapping("/list")
    public List<DtoStudent> findAll() {
        return studentService.findAll();
    }

    



    @Override
    @GetMapping("/list/{id}")
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
       return studentService.getStudentById(id);
    }






    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudent(id);
    }






    @Override
    @PutMapping(path = "/update/{id}")
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id , @RequestBody DtoStudentIU updateDtoStudentIU) {        
        return studentService.updateStudent(id, updateDtoStudentIU);
    }


}
