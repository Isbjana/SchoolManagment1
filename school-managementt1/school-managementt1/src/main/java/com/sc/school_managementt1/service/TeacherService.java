package com.sc.school_managementt1.service;

import com.sc.school_managementt1.entity.Teacher;
import com.sc.school_managementt1.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public List<Teacher> getTeacherByFirstName(String firstName) {
        return teacherRepository.findTeacherByFirstName(firstName);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }
}

