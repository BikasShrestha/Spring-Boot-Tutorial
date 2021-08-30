package com.spring.demo.repo;

import org.springframework.stereotype.Repository;
import com.spring.demo.student.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query( "SELECT s FROM Student s WHERE s.email =?1")
	Optional<Student> findByEmail(String email);

	//Optional<Student> findStudentByEmail(String email);
}
