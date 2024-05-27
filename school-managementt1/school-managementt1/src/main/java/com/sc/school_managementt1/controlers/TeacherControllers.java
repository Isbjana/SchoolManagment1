package com.sc.school_managementt1.controlers;

import com.sc.school_managementt1.entity.Teacher;
import com.sc.school_managementt1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherControllers {


    private  final TeacherService teacherService;
    @Autowired
    public TeacherControllers(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/search")
    public List<Teacher> getTeacherByFirstName(@RequestParam String firstName) {
        return teacherService.getTeacherByFirstName(firstName);
    }

    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }
}

