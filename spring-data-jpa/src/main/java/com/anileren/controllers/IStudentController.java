package com.anileren.controllers;

import java.util.List;

import com.anileren.dto.DtoStudent;
import com.anileren.dto.DtoStudentIU;

public interface IStudentController {
    // POST
    public DtoStudent saveStudent(DtoStudentIU DtoStudentIU);

    
    // GET
    public List<DtoStudent> findAll();
    public DtoStudent getStudentById(Integer id);


    // DELETE
    public void deleteStudent(Integer id);


    // PUT
    public DtoStudent updateStudent(Integer id, DtoStudentIU updateDtoStudentIU);

}
