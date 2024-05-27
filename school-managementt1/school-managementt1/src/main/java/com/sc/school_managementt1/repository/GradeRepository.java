package com.sc.school_managementt1.repository;

import com.sc.school_managementt1.entity.Course;
import com.sc.school_managementt1.entity.Grade;
import com.sc.school_managementt1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {
    List<Grade> findByStudent(Student student);

    List<Grade> findByCourse(Course course);
}
