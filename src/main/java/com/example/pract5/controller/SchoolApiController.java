package com.example.pract5.controller;

import com.example.pract5.model.ErrorResponse;
import com.example.pract5.model.School;
import com.example.pract5.repository.SchoolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/School/")
public class SchoolApiController {
    private final SchoolRepository schoolRepository;

    public SchoolApiController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
    @GetMapping
    public List<School>getAllSchools(){return schoolRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<School> getSchoolById(@PathVariable Long id){return schoolRepository.findById(id);}
    @PostMapping
    public School createSchool(@RequestBody School school){return schoolRepository.save(school);}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSchool(@PathVariable Long id, @RequestBody School school){
        if (!schoolRepository.existsById(id)){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Школа по id не найдена");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        school.setId(id);
        schoolRepository.save(school);
        return new ResponseEntity<>(schoolRepository, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable Long id){
        if (!schoolRepository.existsById(id)){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Школа по id не найдена");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        schoolRepository.deleteById(id);
        return new ResponseEntity<>(schoolRepository, HttpStatus.OK);
    }
}
