package com.sc.school_managementt1.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity

public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String presenceStatus;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public Attendance() {
    }

    public Attendance(Long id, Date date, String presenceStatus, Student student, Course course) {
        this.id = id;
        this.date = date;
        this.presenceStatus = presenceStatus;
        this.student = student;
        this.course = course;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPresenceStatus() {
        return presenceStatus;
    }

    public void setPresenceStatus(String presenceStatus) {
        this.presenceStatus = presenceStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", date=" + date +
                ", presenceStatus='" + presenceStatus + '\'' +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}


