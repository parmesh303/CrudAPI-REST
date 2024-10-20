package com.lwpp.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lwpp.rest.entity.Course;
import com.lwpp.rest.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {

		return "Welcome to REstAPI_Course_API";

	}

	@GetMapping("health")
	public String run(String... args) throws Exception {
		return "Application is up and running.";

	}

	// Get All Course
	@GetMapping("courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();

	}

	// get course by ID
	@GetMapping("/course/{courseId}")
	public Course getCoursebyId(@PathVariable String courseId) {
		return this.courseService.getCourseById(Long.parseLong(courseId));
	}

	// create a course
	@PostMapping(path = "/courses", consumes = "application/json")
	public Course addCourse(@RequestBody Course course) {

		return this.courseService.addCourse(course);

	}

	// update a course
	@PutMapping(path = "courses", consumes = "application/json")
	public Course updatCourse(@RequestBody Course course) {

		return this.courseService.updateCourse(course);

	}
		//delete a course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {

		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
