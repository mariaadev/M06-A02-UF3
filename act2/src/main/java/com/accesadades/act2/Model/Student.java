package com.accesadades.act2.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Document(collection="students")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
	@Id
    private String id;
    private String name;
    private String lastname1;
    private String lastname2;
    private String gender;
    private String email;
    private String phone;
    private int birth_year;
    private String dni;
}
