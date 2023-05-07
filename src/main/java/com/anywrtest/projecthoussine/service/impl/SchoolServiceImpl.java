package com.anywrtest.projecthoussine.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anywrtest.projecthoussine.modele.ClassRoom;
import com.anywrtest.projecthoussine.modele.Student;
import com.anywrtest.projecthoussine.repository.ClassRoomRepository;
import com.anywrtest.projecthoussine.repository.StudentRepository;
import com.anywrtest.projecthoussine.repository.TeacherRepository;
import com.anywrtest.projecthoussine.service.SchoolService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService{

    private final StudentRepository   studentRepository;
    private final ClassRoomRepository classRoomRepository;
    private final TeacherRepository   teacherRepository;
    

	@Override
	public Page<Student> findByClassRoomName(String name , Pageable pageable) {	
		return studentRepository.findByClassRoomName(name, pageable);
	}
	
	@Override
	public Page<Student> findStudentByTeacherFullName(String fullName, Pageable pageable) {
	    Page<ClassRoom> listClassRoom = classRoomRepository.findByTeacherFullName(fullName, pageable);
	    Page<Student> result;

	    if (listClassRoom != null && !listClassRoom.isEmpty()) {
	        ClassRoom currentClassRoom = listClassRoom.getContent().get(0);
	        result = studentRepository.findByClassRoomId(currentClassRoom.getId(), pageable);
	    } else {
	        result = Page.empty();
	    }
	    result.forEach((n) -> {
	        System.out.println(n);
	    });
	    return result;
	}

	@Override
	public Page<Student> findAllStudent(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}
	
}


