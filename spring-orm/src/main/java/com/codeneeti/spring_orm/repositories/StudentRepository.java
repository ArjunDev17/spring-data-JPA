package com.codeneeti.spring_orm.repositories;

import com.codeneeti.spring_orm.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
