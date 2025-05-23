package com.accesadades.act2.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accesadades.act2.DTO.StudentDTO;
import com.accesadades.act2.Model.Student;
import com.accesadades.act2.Serveis.StudentService;
import com.accesadades.act2.Serveis.StudentServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @Autowired StudentServiceImpl studentServiceImpl;

    @GetMapping("/")
    public String iniciar(){
        return "API Students";
    }

    @PostMapping("/save") 
    public Mono<Student> inserirStudent(@RequestBody StudentDTO studentDTO){
        return studentService.save(studentDTO);
    }

    @GetMapping("/student/{id}")
    public Mono<Student> cercaStudentPerId(@PathVariable String id){
        return studentService.findById(id);
    }

    @GetMapping("/all")
    public Flux<Student> llistarStudents(){
        return studentService.findAll();
    }

    @PutMapping("/update/{id}") 
    public Mono<Student> updateStudent(@PathVariable String id, @RequestBody StudentDTO dto) {
        return studentService.update(dto);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public Mono<String> deleteStudent(@PathVariable String id) {
        return studentService.delete(id)
          .thenReturn("Estudiant eliminat correctament amb Id: " + id);
    }

    @GetMapping("/cercaBirthYear90")
    public Flux<Student> cercarStudentsNascutsAnys90(){
        return studentServiceImpl.findByBirthYear();
    }

    @GetMapping("/cercaNameAcabatEn")
    public Flux<Student> cercarStudentsAcabatsEn(@RequestParam String sufix){
        return studentServiceImpl.findByNameEndingWith(sufix);
    }




}
