package com.lwpp.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwpp.rest.dao.CoursDao;
import com.lwpp.rest.entity.Course;
import com.lwpp.rest.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursDao coursDao;

    @Override
    public List<Course> getCourses() {
        return coursDao.findAll();
    }

    @Override
    public Course getCourseById(long courseId) {
        return coursDao.findById(courseId).orElse(null); // use findById instead of getOne
    }

    @Override
    public Course addCourse(Course course) {
        coursDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        coursDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        coursDao.deleteById(courseId);
    }
}
