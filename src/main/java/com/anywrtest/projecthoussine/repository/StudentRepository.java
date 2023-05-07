package com.anywrtest.projecthoussine.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.anywrtest.projecthoussine.modele.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Page<Student> findByClassRoomId(Long id ,Pageable pageable);
	Page<Student> findByClassRoomName(String name ,Pageable pageable );
	Page<Student> findAll(Pageable pageable);

}
