package com.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enitity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

	boolean existsByNameOrBranch(String name,String branch);

	boolean existsByName(String name);

	
	
}
