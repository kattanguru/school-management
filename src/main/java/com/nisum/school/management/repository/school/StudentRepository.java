package com.nisum.school.management.repository.school;

import com.nisum.school.management.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StudentRepository extends ReactiveMongoRepository<Student, String> {
}
