package com.controller;


import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exception.badRequestException;
import com.models.Student;
import com.service.StudentService;

import javassist.NotFoundException;
@RestController
public class StudentController {

	Logger logger = org.slf4j.LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentService ss;
	
	
	@GetMapping("/getStudentBy/{id}")
	public ResponseEntity<Object> getName(@PathVariable int id) {
		return ss.getStudentById(id);
		
	}
	
	@GetMapping("/getId")
	public String getId(int id) {
		return "ab"+id+"good";
	}
	
	@GetMapping("/getAll")
	public List<com.enitity.Student> getAll() {
	   logger.info("Inside getAll method");
		return ss.getAll();
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<Object> addStudent(@RequestBody Student student) 
	{
		logger.info("adding the student");
		if(student.getName().isBlank() || student.getBranch().isBlank() || student.getYear().isBlank())
			throw new badRequestException(); 
		
		return ss.addStudent(student);
	}
	
	//@Scheduled(fixedRate = 5000)
	public void scheduleJob() {
		logger.info("scheduled job is running");
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file)
	{
		
		return "uploaded";
		
	}
	
    @GetMapping("/existById/{id}")
	public ResponseEntity<Boolean> existById(int id) {
    	
    	
    	return new ResponseEntity<Boolean>(ss.existById(id),HttpStatus.OK);
    }
    
    @GetMapping("/existByName/{name}")
   	public ResponseEntity<Boolean> existByName(String  name,String branch) {
       	if(name.isBlank() || name.isEmpty())
       		throw new badRequestException();
       	
       	return new ResponseEntity<Boolean>(ss.existByName(name,branch),HttpStatus.OK);
       }
  
    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int  id) {
	
    	if (!ss.deleteStudent(id)) {
		return new ResponseEntity<Object>("error in deleting student",HttpStatus.INTERNAL_SERVER_ERROR);	
		}
    	
    	return new ResponseEntity<Object>("deleted",HttpStatus.OK);
    }
    @PutMapping("/updateStudent/{id}")
   	public ResponseEntity<Object> updateStudent(@PathVariable int id,@RequestBody Student student) throws NotFoundException {
       
    	
    	if(ss.updateStudent(id,student)) {
    		return new ResponseEntity<>("updated successfully",HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<Object>("error in updating data",HttpStatus.NOT_FOUND);
       }
    
    
}
