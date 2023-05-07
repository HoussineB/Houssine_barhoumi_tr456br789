package com.anywrtest.projecthoussine.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anywrtest.projecthoussine.modele.Student;
import com.anywrtest.projecthoussine.service.SchoolService;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final SchoolService schoolService;

    public StudentController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    
    @GetMapping("/getStudentsByClassRoomName/{className}")
    public ResponseEntity<Page<Student>> getStudentsByClassRoomName1(
            @PathVariable String className,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentsPage = schoolService.findByClassRoomName(className, pageable);
        return ResponseEntity.ok(studentsPage);
    }
    
    ////////////without pagination
    /*
    @GetMapping("/getTeacherByFullName/{fullName}")
    public Teacher findByTeacherByFullName(@PathVariable String fullName) {
        return schoolService.findStudentByTeacherFullName(fullName);
    }*/
    
    
    @GetMapping("/getByTeacherByFullName/{fullName}")
    public ResponseEntity<Page<Student>> findStudentByTeacherFullName(
    		@PathVariable String fullName,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentsPage = schoolService.findStudentByTeacherFullName(fullName, pageable);
        return ResponseEntity.ok(studentsPage);
    }
    
    ///////////findAllStudent pagination with PathVariable
    
	@GetMapping("/{page}/{size}")
	public Page<Student> findAllStudent(@PathVariable Integer size ,@PathVariable Integer page ){
		Pageable pageable = PageRequest.of(page, size);
    	return schoolService.findAllStudent(pageable);
	}
    
    /////// findAllStudent with pageable with RequestParam(defaultValue)
    @GetMapping
    public ResponseEntity<Page<Student>> findAllStudents(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> studentsPage = schoolService.findAllStudent(pageable);
        return ResponseEntity.ok(studentsPage);
    }
}
