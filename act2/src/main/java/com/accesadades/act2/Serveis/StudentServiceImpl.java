package com.accesadades.act2.Serveis;

import org.springframework.stereotype.Service;

import com.accesadades.act2.DTO.StudentDTO;
import com.accesadades.act2.Model.Student;
import com.accesadades.act2.Respositoris.StudentRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo StudentRepo) {
        this.studentRepo = StudentRepo;
    }

        @Override
    public Mono<Student> save(StudentDTO dto) {
        Student student = DTOaEntitat(dto);
        return studentRepo.save(student);
    }

    @Override
    public Mono<Student> update(StudentDTO dto) {
        return studentRepo.findById(dto.id())
            .flatMap(existing -> {
                Student updated = DTOaEntitat(dto);
                updated.setId(existing.getId()); 
                return studentRepo.save(updated);
            });
    }

    @Override
    public Mono<Student> findById(String id) {
        return studentRepo.findById(id);
    }

    @Override
    public Flux<Student> findAll() {
        return studentRepo.findAll();
    }



    @Override
    public Mono<Void> delete(String id) {
        return studentRepo.deleteById(id);
    }

    private Student DTOaEntitat(StudentDTO dto) {
            return new Student(
                dto.id(),          
                dto.name(),
                dto.lastname1(),
                dto.lastname2(),
                dto.gender(),
                dto.email(),
                dto.phone(),
                dto.birth_year(),
                dto.dni()
            );
    }

    public Flux<Student> findByBirthYear() {
        return studentRepo.findByBirthDatyInNineties();
    }
}
