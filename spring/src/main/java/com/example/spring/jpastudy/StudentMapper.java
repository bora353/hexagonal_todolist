package com.example.spring.jpastudy;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "studentDto.schoolId", target = "school.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "age", ignore = true)
    @Mapping(target = "studentProfile", ignore = true)
    Student toStudent(StudentDto studentDto);

    StudentResponseDto toStudentResponseDto(Student student);
}
