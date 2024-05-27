package com.sc.school_managementt1.repository;

import com.sc.school_managementt1.entity.Course;
import com.sc.school_managementt1.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByTeacher(Teacher teacher);



}
