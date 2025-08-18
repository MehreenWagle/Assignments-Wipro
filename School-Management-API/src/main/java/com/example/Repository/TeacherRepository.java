package com.example.Repository;

import com.example.entities.Teacher;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    
    @Query(value = "SELECT * FROM Teacher WHERE qualification = :qualification", nativeQuery = true)
    List<Teacher> findByQualificationNative(@Param("qualification") String qualification);

    
    @Query("SELECT t FROM Teacher t WHERE t.age < :age")
    List<Teacher> findYoungTeachers(@Param("age") int age);
}
