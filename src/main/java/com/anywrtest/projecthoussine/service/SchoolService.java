package com.anywrtest.projecthoussine.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anywrtest.projecthoussine.modele.Student;


public interface SchoolService {
    Page<Student> findByClassRoomName(String name, Pageable pageable);
    Page<Student> findAllStudent(Pageable pageable);
    Page<Student> findStudentByTeacherFullName(String fullName ,Pageable pageable);
    
}
