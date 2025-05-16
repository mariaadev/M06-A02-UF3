package com.accesadades.act2.Respositoris;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.accesadades.act2.Model.Student;

@Repository
@EnableReactiveMongoRepositories

public interface StudentRepo extends ReactiveMongoRepository<Student, String>{
    
}
