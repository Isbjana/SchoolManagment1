package com.sc.school_managementt1.repository;

import com.sc.school_managementt1.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    List<Teacher> findTeacherByFirstName(String firstName);
}
