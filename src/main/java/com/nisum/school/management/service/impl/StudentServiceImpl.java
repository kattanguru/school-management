package com.nisum.school.management.service.impl;

import com.nisum.school.management.model.Student;
import com.nisum.school.management.repository.school.StudentRepository;
import com.nisum.school.management.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Flux<Student> getStudents() {
        log.debug("START :: Retrieve Students Details");
        return studentRepository.findAll();
    }

    public Mono<Student> getStudent(Long Id) {
        log.debug("Retrieve Student Details By ID : {}", Id);
        return studentRepository.findById(String.valueOf(Id));
    }

    public Mono<Student> addStudent(Student student) {
        log.debug("Add Student Details : {}", student);
        return studentRepository.save(student);
    }

    public Mono<Student> updateStudentDetails(Student student) {
        log.debug("Update Student Details : {}", student);
        return studentRepository.save(student);
    }

    public Mono<Void> removeStudentDetails(Long Id) {
        log.debug("Remove Student Details : {}", Id);
        return studentRepository.deleteById(String.valueOf(Id));
    }
}
