package com.anileren.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anileren.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    //HQL: Sınıfın ismi ve değişken isimleri kullanılarak yazılır. @Query anotasyonunun nativeQuery değerine false verirseniz kullanabilirsiniz.
    //SQL: Tablo ismi ve tablo içerisindeki kolon isimleri kullanılarak yazılır. @Query anotasyonunun nativeQuery değerine true verirseniz kullanabilirsiniz.

    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudents();
    
}
