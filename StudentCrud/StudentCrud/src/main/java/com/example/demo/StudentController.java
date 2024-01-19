package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudRepository repo;
	
	   @PostMapping("/students") 
	    public String createNewStudent(@RequestBody Student student) {
	        repo.save(student);
	        return "student created in db";
	    }
	   
	   
	   @GetMapping("/students")
	   public ResponseEntity<List<Student>> getStudData() {
		   List<Student> studList = new ArrayList<>();
		   repo.findAll().forEach(studList::add);
		   return new ResponseEntity<List<Student>>(studList,HttpStatus.OK);
	   }
	   
	   
	   @GetMapping("/students/{id}")
	   public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	       Optional<Student> studentOptional = repo.findById(id);

	       if (studentOptional.isPresent()) {
	           Student student = studentOptional.get();
	           return new ResponseEntity<>(student, HttpStatus.OK);
	       } else {
	           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	       }
	   }
	   
	   @PutMapping("/students/{id}")
	   public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
	       Optional<Student> optionalStudent = repo.findById(id);

	       if (optionalStudent.isPresent()) {
	           Student existingStudent = optionalStudent.get();
	           existingStudent.setStudName(updatedStudent.getStudName());
	           existingStudent.setStudAge(updatedStudent.getStudAge());
	           existingStudent.setStudCity(updatedStudent.getStudCity());
	           
	           repo.save(existingStudent);
	           
	           return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
	       } else {
	           return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	       }
	   }

	   @DeleteMapping("/students/{id}")
	   public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
	       Optional<Student> optionalStudent = repo.findById(id);

	       if (optionalStudent.isPresent()) {
	           repo.deleteById(id);
	           return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
	       } else {
	           return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	       }
	   }

	   
}
