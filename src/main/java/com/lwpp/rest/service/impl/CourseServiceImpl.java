package com.lwpp.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lwpp.rest.entity.Course;
import com.lwpp.rest.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();

		list.add(new Course(1, "Java", "This is java course"));
		list.add(new Course(2, "NodeJs", "This is NodeJs course"));
	}

	@Override
	public List<Course> getCourses() {

		return list;
	}

	@Override
	public Course getCourseById(long courseId) {

		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId)
				;
			{
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {

		list.forEach(e->{
			
			if (e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
				
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {

		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}


}
