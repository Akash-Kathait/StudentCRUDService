package com.studentapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import com.enitity.Student;
import com.repository.StudentRepo;
import com.service.StudentService;


@SpringBootTest
class StudentApplicationTests {
	

    
	@Test
	void contextLoads() {
	}
	
	@TestConfiguration
	 static class StudentTestContextConfiguration {
		@Bean
		public  StudentService getStudentService() {
			return new StudentService();
		}
		
	}
	
	@Autowired
	StudentService ss;
	
	@MockBean
	StudentRepo sr;
	
	@Autowired
	Student sc;
	
	@Bean
	 public Student getStudent() {
		return new Student(2,"akash","cse","4th");
	}
	

}