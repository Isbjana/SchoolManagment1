package com.sc.school_managementt1.service;

import com.sc.school_managementt1.entity.Course;
import com.sc.school_managementt1.entity.Teacher;
import com.sc.school_managementt1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.getById(id);
    }

    public List<Course> getCoursesByTeacher(Teacher teacher) {
        return courseRepository.findByTeacher(teacher);
    }

    public Course saveCourse(Course course) {
        // Ensure the course ID is null to force creation of a new entity
        if (course.getId() != null) {
            throw new IllegalArgumentException("Course ID must be null for save operation.");
        }
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setName(updatedCourse.getName());
            existingCourse.setDescription(updatedCourse.getDescription());
            existingCourse.setSchedule(updatedCourse.getSchedule());
            existingCourse.setTeacher(updatedCourse.getTeacher());
            return courseRepository.save(existingCourse);
        } else {
            throw new IllegalArgumentException("Course not found with id: " + id);
        }
    }


    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}
