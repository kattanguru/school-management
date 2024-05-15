package com.nisum.school.management.service;

import com.nisum.school.management.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Flux<Student> getStudents();

    Mono<Student> getStudent(Long Id);

    Mono<Student> addStudent(Student student);

    Mono<Student> updateStudentDetails(Student student);

    Mono<Void> removeStudentDetails(Long Id);
}
