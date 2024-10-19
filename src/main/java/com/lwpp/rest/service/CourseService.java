package com.lwpp.rest.service;

import java.util.List;

import com.lwpp.rest.entity.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourseById(long courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);

}