package com.accesadades.act2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accesadades.act2.DTO.StudentDTO;
import com.accesadades.act2.Model.Student;
import com.accesadades.act2.Serveis.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String iniciar(){
        return "API Students";
    }

    @PostMapping("/save") 
    public String inserirStudent(@RequestBody StudentDTO studentDTO){
        studentService.save(studentDTO);
        return "Estudent insertat amb éxit";
    }

    @GetMapping("/{Id}")
    public Mono<Student> cercaStudentPerId(@RequestParam String id){
        return studentService.findById(id);
    }

    @GetMapping("/all")
    public Flux<Student> llistarStudents(){
        return studentService.findAll();
    }

    @PutMapping("/update") 

    @DeleteMapping("/{Id}")



}
