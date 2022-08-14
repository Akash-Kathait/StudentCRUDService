package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.studentDao;
import com.models.Student;
import com.repository.StudentRepo;

import javassist.NotFoundException;


@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	 
	@Autowired
	studentDao dao;
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(StudentService.class);
	public ResponseEntity<Object> addStudent(Student student)
	{
		int i = dao.addStudent(student);
		if(i ==1 )
			return new ResponseEntity<Object>("saved successfully",HttpStatus.CREATED);
		
		else
			return new ResponseEntity<Object>("request failed",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	public  List<com.enitity.Student> getAll() {
	  
		logger.debug("fetching the all student list ");
		List<com.enitity.Student> list= (List<com.enitity.Student>) repo.findAll();
		 
		if(list.size() == 0)
			logger.warn("student list is empty");
		
		
		return list;
	
	}

	public ResponseEntity<Object> getStudentById(int id) {
		logger.info("getting the student by id");
		Optional<com.enitity.Student> item = null;
		item =	repo.findById(id);
		logger.debug("value "+ item);
		if(!item.isPresent())
		     return new ResponseEntity<Object>("No student found with id",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(item,HttpStatus.OK);
		
	}

	public boolean existById(int id) {
		logger.info("inside existById "+id);
		boolean isExist  =repo.existsById(id);
		
		logger.info("value : "+ isExist);
	    
	    return isExist;
	    

	}

	public Boolean existByName(String name, String branch) {
		logger.info("inside existByName "+ name);
	  
		boolean isExist  =repo.existsByNameOrBranch(name ,branch);
	
		logger.info("value : "+ isExist);
	    return isExist;
		
		
	}

	public boolean deleteStudent(int id) {

		logger.info("inside deleteStudent "+ id);
		  
		 try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error("error while deleting student " , e);
			return false;
		}
		
	    return true;
		
	}

	public boolean updateStudent(int id, Student reqStudent) throws NotFoundException {
	
		Optional<com.enitity.Student> s =  repo.findById(id);
		if(!s.isPresent())
		     throw new NotFoundException("no record found to update with that id ");
			
	    s.get().setbranch(reqStudent.getBranch());
	    s.get().setName(reqStudent.getName());
	    s.get().setYear(reqStudent.getYear());
		repo.save(s.get());
		
		return true;
	}

	
	
}
