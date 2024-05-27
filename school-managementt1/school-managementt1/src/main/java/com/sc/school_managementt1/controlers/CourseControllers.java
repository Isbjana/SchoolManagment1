package com.sc.school_managementt1.controlers;


import com.sc.school_managementt1.entity.Course;
import com.sc.school_managementt1.entity.Teacher;
import com.sc.school_managementt1.service.CourseService;
import com.sc.school_managementt1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseControllers {

    private  final CourseService courseService;
    private final TeacherService teacherService;


    @Autowired
    public CourseControllers(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping("/getAll")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/getById/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/getCoursesByTeacher")
    public List<Course> getCoursesByTeacher(@RequestParam Long teacherId) {
        // You need to fetch the Teacher object from the database first
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (teacher != null) {
            return courseService.getCoursesByTeacher(teacher);
        } else {
            throw new IllegalArgumentException("Teacher not found with id: " + teacherId);
        }
    }


    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        // Ensure the course ID in the path matches the ID in the request body
        if (!id.equals(course.getId())) {
            throw new IllegalArgumentException("Course ID in path must match the ID in request body.");
        }
        return courseService.updateCourse(id,course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }


}
