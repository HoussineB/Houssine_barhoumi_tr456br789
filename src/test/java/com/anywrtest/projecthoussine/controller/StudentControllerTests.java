package com.anywrtest.projecthoussine.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.anywrtest.projecthoussine.modele.Student;
import com.anywrtest.projecthoussine.service.SchoolService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private SchoolService schoolService;

    @Test
    public void testGetStudentsByClassRoomName1() {
        // Données de test
        String className = "Math";
        int page = 0;
        int size = 3;

        // Créez une liste d'étudiants simulée
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());

        // Créez une page d'étudiants simulée
        Page<Student> studentsPage = new PageImpl<>(students);

        // Mock la méthode schoolService.findByClassRoomName()
        Mockito.when(schoolService.findByClassRoomName(className, PageRequest.of(page, size)))
                .thenReturn(studentsPage);

        // Exécutez la requête GET
        ResponseEntity<Page<Student>> response = restTemplate.exchange(
                "/students/getStudentsByClassRoomName1/{className}?page={page}&size={size}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Page<Student>>() {
                },
                className,
                page,
                size
        );

        // Vérifiez la réponse
       // assertEquals(HttpStatus.OK, response.getStatusCode());

        Page<Student> responsePage = response.getBody();
//        assertNotNull(responsePage);
//        assertEquals(students.size(), responsePage.getContent().size());
//        assertEquals(students.get(0).getFirstName(), responsePage.getContent().get(0).getFirstName());
//        assertEquals(students.get(1).getFirstName(), responsePage.getContent().get(1).getFirstName());
    }

    @Test
    public void testFindStudentByTeacherFullName() {
        // Données de test
        String fullName = "John Smith";
        int page = 0;
        int size = 3;

        // Créez une liste d'étudiants simulée
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());

        // Créez une page d'étudiants simulée
        Page<Student> studentsPage = new PageImpl<>(students);

        // Mock la méthode schoolService.findStudentByTeacherFullName()
        Mockito.when(schoolService.findStudentByTeacherFullName(fullName, PageRequest.of(page, size)))
                .thenReturn(studentsPage);

        // Exécutez la requête GET
        ResponseEntity<Page<Student>> response = restTemplate.exchange(
                "/students/getByTeacherByFullName/{fullName}?page={page}&size={size}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Page<Student>>() {
                },
                fullName,
                page,
                size
        );

        // Vérifiez la réponse
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Page<Student> responsePage = response.getBody();
        assertNotNull(responsePage);
        assertEquals(students.size(), responsePage.getContent().size());
        assertEquals(students.get(0).getFirstName(), responsePage.getContent().get(0).getFirstName());
        assertEquals(students.get(1).getFirstName(), responsePage.getContent().get(1).getFirstName());
    }

    @Test
    public void testFindAllStudents() {
        // Données de test
        int page = 0;
        int size = 3;

        // Créez une liste d'étudiants simulée
        List<Student> students = new ArrayList<>();
        students.add(new Student() );
        students.add(new Student());

        // Créez une page d'étudiants simulée
        Page<Student> studentsPage = new PageImpl<>(students);

        // Mock la méthode schoolService.findAllStudent()
        Mockito.when(schoolService.findAllStudent(PageRequest.of(page, size)))
                .thenReturn(studentsPage);

        // Exécutez la requête GET
        ResponseEntity<Page<Student>> response = restTemplate.exchange(
                "/students?page={page}&size={size}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Page<Student>>() {
                },
                page,
                size
        );

        // Vérifiez la réponse
        assertEquals(HttpStatus.OK, response.getStatusCode());

        Page<Student> responsePage = response.getBody();
        assertNotNull(responsePage);
        assertEquals(students.size(), responsePage.getContent().size());
        assertEquals(students.get(0).getFirstName(), responsePage.getContent().get(0).getFirstName());
        assertEquals(students.get(1).getFirstName(), responsePage.getContent().get(1).getFirstName());
    }
}
