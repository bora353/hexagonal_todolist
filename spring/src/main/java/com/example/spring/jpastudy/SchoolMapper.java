package com.example.spring.jpastudy;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SchoolMapper {

    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    School toSchool(SchoolDto schoolDto);

    SchoolDto toSchoolDto(School school);

}
