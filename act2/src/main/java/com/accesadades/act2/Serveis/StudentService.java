package com.accesadades.act2.Serveis;
import com.accesadades.act2.DTO.StudentDTO;
import com.accesadades.act2.Model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
    Mono<Student> save(StudentDTO dto); 
    Mono<Student> findById(String id); 
    Flux<Student> findAll(); 
    Mono<Student> update(StudentDTO nom_dto);
    Mono<Void> delete(String id);

}
