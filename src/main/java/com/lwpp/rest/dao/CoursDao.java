package com.lwpp.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lwpp.rest.entity.Course;

@Repository
public interface CoursDao extends JpaRepository<Course, Long> {
}
