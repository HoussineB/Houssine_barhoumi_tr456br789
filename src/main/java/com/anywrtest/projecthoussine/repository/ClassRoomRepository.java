package com.anywrtest.projecthoussine.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.anywrtest.projecthoussine.modele.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

	 //////////////// I made the conctination of firstName and LastName at entity level
		/*@Query("SELECT TC FROM Teacher TC WHERE CONCAT(TC.firstName, ' ', TC.lastName) LIKE  :fullName")*/
	
	Page<ClassRoom> findByTeacherFullName(String fullName ,Pageable pageable);
}


