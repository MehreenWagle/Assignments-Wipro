package com.example.Repository;

import com.example.entities.School;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    
    @Query(value = "SELECT * FROM School WHERE school_name = :name", nativeQuery = true)
    List<School> findBySchoolNameNative(@Param("name") String name);

    
    @Query("SELECT s FROM School s WHERE s.teacher.experience > :exp")
    List<School> findSchoolsWithExperiencedTeachers(@Param("exp") int experience);
}
