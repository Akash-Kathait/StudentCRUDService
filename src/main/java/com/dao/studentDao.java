package com.dao;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.models.Student;

@Repository
public class studentDao  {

	@Autowired
	JdbcTemplate jdbcTemplate;
	Logger logger = org.slf4j.LoggerFactory.getLogger(studentDao.class);
	 public int addStudent(Student student) {
		 
		 logger.debug("adding the student");
		
		 logger.debug(student.getName()+" "+ student.getBranch()+" "+ student.getYear());
		 int i= jdbcTemplate.update("insert into student(name,branch,year) values(?,?,?)",student.getName(),student.getBranch(),student.getYear()
				 );
			if(i ==1 )
				logger.debug("added the student successfully");
			
			else
				logger.debug("adding the student request failed");
			 
		 
		 return i;
	 }
}
