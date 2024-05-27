package com.sc.school_managementt1.controlers;

import com.sc.school_managementt1.entity.Attendance;
import com.sc.school_managementt1.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceControllers {

    private  final AttendanceService attendanceService;


    @Autowired
    public AttendanceControllers(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/getAllAttendances")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/student/{studentId}")
    public List<Attendance> getAttendancesByStudent(@PathVariable Long studentId) {
        return attendanceService.getAttendancesByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Attendance> getAttendancesByCourse(@PathVariable Long courseId) {
        return attendanceService.getAttendancesByCourse(courseId);
    }

    @PostMapping("/create")
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @PutMapping("/update/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        return attendanceService.updateAttendance(id, attendance);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAttendanceById(@PathVariable Long id) {
        attendanceService.deleteAttendanceById(id);
    }
}

