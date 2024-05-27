package com.sc.school_managementt1.repository;

import com.sc.school_managementt1.entity.Attendance;
import com.sc.school_managementt1.entity.Course;
import com.sc.school_managementt1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    List<Attendance> findByStudent(Student student);

    List<Attendance> findByCourse(Course course);


}
