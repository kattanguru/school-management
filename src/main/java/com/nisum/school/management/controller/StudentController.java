package com.nisum.school.management.controller;

import com.nisum.school.management.model.Student;
import com.nisum.school.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    private Mono<Student> save(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    private Mono<ResponseEntity<String>> delete(@PathVariable Long id) {

        return studentService.removeStudentDetails(id).flatMap(user -> Mono.just(ResponseEntity.ok("Deleted Successfully"))).switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping()
    private Mono<ResponseEntity<Student>> update(@RequestBody Student student) {
        return studentService.addStudent(student).flatMap(user1 -> Mono.just(ResponseEntity.ok(user1))).switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping()
    private Flux<Student> findAll() {

        return studentService.getStudents();
    }

    @GetMapping(value = "/{id}")
    private Mono<Student> findStudentById(@PathVariable Long id) {

        return studentService.getStudent(id);
    }
}