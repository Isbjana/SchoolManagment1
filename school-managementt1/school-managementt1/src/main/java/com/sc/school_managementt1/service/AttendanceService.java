package com.sc.school_managementt1.service;

import com.sc.school_managementt1.entity.Attendance;
import com.sc.school_managementt1.entity.Course;
import com.sc.school_managementt1.entity.Student;
import com.sc.school_managementt1.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private  final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository, StudentService studentService, CourseService courseService) {
        this.attendanceRepository = attendanceRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> getAttendancesByStudent(Long studentId) {
        // Fetch student object from database using studentId
        Student student =  studentService.getStudentById(studentId);// Fetch student by ID
        return attendanceRepository.findByStudent(student);
    }

    public List<Attendance> getAttendancesByCourse(Long courseId) {
        // Fetch course object from database using courseId
        Course course = courseService.getCourseById(courseId);// Fetch course by ID
        return attendanceRepository.findByCourse(course);
    }

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Attendance existingAttendance = attendanceRepository.findById(id).orElse(null);
        if (existingAttendance != null) {
            // Update the fields of existingAttendance with updatedAttendance
            existingAttendance.setDate(updatedAttendance.getDate());
            existingAttendance.setPresenceStatus(updatedAttendance.getPresenceStatus());
            existingAttendance.setStudent(updatedAttendance.getStudent());
            existingAttendance.setCourse(updatedAttendance.getCourse());
            return attendanceRepository.save(existingAttendance);
        } else {
            throw new IllegalArgumentException("Attendance not found with id: " + id);
        }
    }

    public void deleteAttendanceById(Long id) {
        attendanceRepository.deleteById(id);
    }
}
