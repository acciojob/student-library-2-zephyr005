package com.driver.controller;

import com.driver.models.Student;
import com.driver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //Add required annotations
    @GetMapping("/get_by_email")
    public ResponseEntity getStudentByEmail(@RequestParam("email") String email){
        Student student = studentService.getDetailsByEmail(email);
        return new ResponseEntity<>("Student details printed successfully " + student, HttpStatus.OK);
    }

    //Add required annotations
    @GetMapping("/get_by_id")
    public ResponseEntity getStudentById(@RequestParam("id") int id){
        Student student = studentService.getDetailsById(id);
        return new ResponseEntity<>("Student details printed successfully " + student, HttpStatus.OK);
    }

    //Add required annotations
    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody Student student){

        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }

    //Add required annotations
    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){

        return new ResponseEntity<>("Student is updated", HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int id){

        return new ResponseEntity<>("Student is deleted", HttpStatus.ACCEPTED);
    }

}
