package com.accesadades.act2.Serveis;

import org.springframework.stereotype.Service;

import com.accesadades.act2.DTO.StudentDTO;
import com.accesadades.act2.Mapper.StudentMapper;
import com.accesadades.act2.Model.Student;
import com.accesadades.act2.Respositoris.StudentRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepo StudentRepo,  StudentMapper studentMapper) {
        this.studentRepo = StudentRepo;
         this.studentMapper = studentMapper;
    }

        @Override
    public Mono<Student> save(StudentDTO dto) {
        Student student = studentMapper.studenDTOToStudent(dto);
        return studentRepo.save(student);
    }

    @Override
    public Mono<Student> update(StudentDTO dto) {
        return studentRepo.findById(dto.id())
            .flatMap(existing -> {
                Student updated = studentMapper.studenDTOToStudent(dto);
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


    public Flux<Student> findByBirthYear() {
        return studentRepo.findByBirthDatyInNineties();
    }

    public Flux<Student> findByNameEndingWith(String suffix) {
        String regex = suffix + "$"; 
        return studentRepo.findByNameMatchingRegex(regex);
    }
}
