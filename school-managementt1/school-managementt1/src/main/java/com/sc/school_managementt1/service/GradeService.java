package com.sc.school_managementt1.service;

import com.sc.school_managementt1.entity.Course;
import com.sc.school_managementt1.entity.Grade;
import com.sc.school_managementt1.entity.Student;
import com.sc.school_managementt1.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GradeService {
    private final GradeRepository gradeRepository;
    private  final StudentService studentService;
    private final CourseService courseService;
    @Autowired
    public GradeService(GradeRepository gradeRepository, StudentService studentService, CourseService courseService) {
        this.gradeRepository = gradeRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public List<Grade> getGradesByStudent(Long studentId) {
        // Fetch student object from database using studentId
        Student student = studentService.getStudentById(studentId);// Fetch student by ID
        return gradeRepository.findByStudent(student);
    }

    public List<Grade> getGradesByCourse(Long courseId) {
        // Fetch course object from database using courseId
        Course course = courseService.getCourseById(courseId); // Fetch course by ID
        return gradeRepository.findByCourse(course);
    }

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long id, Grade updatedGrade) {
        Grade existingGrade = gradeRepository.findById(id).orElse(null);
        if (existingGrade != null) {
            // Update the fields of existingGrade with updatedGrade
            existingGrade.setValue(updatedGrade.getValue());
            existingGrade.setType(updatedGrade.getType());
            existingGrade.setStudent(updatedGrade.getStudent());
            existingGrade.setCourse(updatedGrade.getCourse());
            return gradeRepository.save(existingGrade);
        } else {
            throw new IllegalArgumentException("Grade not found with id: " + id);
        }
    }

    public void deleteGradeById(Long id) {
        gradeRepository.deleteById(id);
    }

}
