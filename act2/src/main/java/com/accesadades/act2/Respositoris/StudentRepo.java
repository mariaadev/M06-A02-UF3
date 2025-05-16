package com.accesadades.act2.Respositoris;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.accesadades.act2.Model.Student;

import reactor.core.publisher.Flux;

@Repository
@EnableReactiveMongoRepositories

public interface StudentRepo extends ReactiveMongoRepository<Student, String>{
    
    @Query("{ 'birth_daty': { $gte: 1990, $lte: 1999 } }")
    Flux<Student> findByBirthDatyInNineties();
}
