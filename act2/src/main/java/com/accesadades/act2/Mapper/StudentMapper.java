package com.accesadades.act2.Mapper;

import java.util.List;

import org.mapstruct.*;

import com.accesadades.act2.DTO.StudentDTO;
import com.accesadades.act2.Modal.Student;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    StudentDTO studentToStudentDTO(Student student);
    Student studenDTOtToStudent(StudentDTO studentDTO);

    List<StudentDTO> studentsToStudentDTOs(List<Student> students);
    List<Student> studentsDTOsToStudents(List<StudentDTO> StudentDTOs);
}
