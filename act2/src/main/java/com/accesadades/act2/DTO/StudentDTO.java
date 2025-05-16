package com.accesadades.act2.DTO;

public record StudentDTO (
    String id, 
    String name,
    String lastname1,
    String lastname2,
    String gender,
    String email,
    String phone,
    int birth_year,
    String dni
) {}

