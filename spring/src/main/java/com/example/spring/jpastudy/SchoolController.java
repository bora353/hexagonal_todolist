package com.example.spring.jpastudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto){
        School school = SchoolMapper.INSTANCE.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return schoolRepository.findAll()
                .stream().map(SchoolMapper.INSTANCE::toSchoolDto)
                .collect(Collectors.toList());
    }
}
