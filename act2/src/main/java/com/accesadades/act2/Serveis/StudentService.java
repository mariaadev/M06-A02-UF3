package com.accesadades.act2.Serveis;

import com.accesadades.Modal.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
    Mono<Student> save(); 
    Mono<Student> findById(String id); 
    Flux<Student> findAll(); 
    

}
