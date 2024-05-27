package com.sc.school_managementt1.controlers;

import com.sc.school_managementt1.entity.Grade;
import com.sc.school_managementt1.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeControllers {

    private  final GradeService gradeService;

    @Autowired
    public GradeControllers(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/getAllGrades")
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getGradesByStudent(@PathVariable Long studentId) {
        return gradeService.getGradesByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Grade> getGradesByCourse(@PathVariable Long courseId) {
        return gradeService.getGradesByCourse(courseId);
    }

    @PostMapping("/create")
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @PutMapping("/update/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        return gradeService.updateGrade(id, grade);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGradeById(@PathVariable Long id) {
        gradeService.deleteGradeById(id);
    }
}

