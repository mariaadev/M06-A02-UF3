package com.accesadades.act2.Controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accesadades.act2.DTO.StudentDTO;
import com.accesadades.act2.Serveis.StudentService;

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
        studentService.save()
    }

    @GetMapping("/{Id}") 

    @GetMapping("/all")

    @PutMapping("/update") 

    @DeleteMapping("/{Id}")



}
