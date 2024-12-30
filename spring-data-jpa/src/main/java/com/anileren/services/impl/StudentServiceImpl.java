package com.anileren.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anileren.dto.DtoStudent;
import com.anileren.dto.DtoStudentIU;
import com.anileren.entities.Student;
import com.anileren.repositories.StudentRepository;
import com.anileren.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentRepository studentRepository;




    @Override
    public DtoStudent saveStudent(DtoStudentIU DtoStudentIU) {
        Student student = new Student();
        BeanUtils.copyProperties(DtoStudentIU, student);

        DtoStudent response = new DtoStudent();
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);

        return response;
    }




    @Override
    public List<DtoStudent> findAll() {

    List<Student> studentList = studentRepository.findAllStudents();
    List<DtoStudent> dtoList = new ArrayList<>();

    for (Student student : studentList) {
        DtoStudent dto = new DtoStudent();
        BeanUtils.copyProperties(student, dto);
        dtoList.add(dto);
    }
      return dtoList;
    }




    @Override
    public DtoStudent getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        DtoStudent dtoStudent = new DtoStudent();

        if (optional.isPresent()){
            Student dbStudent = optional.get();
            
            BeanUtils.copyProperties(dbStudent, dtoStudent); 
        }
        return dtoStudent;
    }


    
    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);

        if(optional.isPresent()){
            studentRepository.delete(optional.get());
        }

    }



    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU updateDtoStudentIU) {
      Optional<Student> optional =  studentRepository.findById(id);
      DtoStudent dto = new DtoStudent();

      if(optional.isPresent()){

        Student dbStudent = optional.get();
        dbStudent.setFirstName(updateDtoStudentIU.getFirstName());
        dbStudent.setLastName(updateDtoStudentIU.getLastName());
        dbStudent.setBirthOfDate(updateDtoStudentIU.getBirthOfDate());
        
        Student updatedStudent = studentRepository.save(dbStudent);

        BeanUtils.copyProperties(updatedStudent, dto);

        return dto;

      }

      return null;
      
}

    
   

    
    

}
