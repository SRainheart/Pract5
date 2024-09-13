package com.example.pract5.controller;

import com.example.pract5.model.Director;
import com.example.pract5.model.ErrorResponse;
import com.example.pract5.repository.DirectorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/Director/")
public class DirectorApiController {
    private final DirectorRepository directorRepository;

    public DirectorApiController(DirectorRepository directorApiController) {
        this.directorRepository = directorApiController;
    }
    @GetMapping
    public List<Director> getAllDirector(){return directorRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Director> getDirectorById(@PathVariable Long id){return directorRepository.findById(id);}
    @PostMapping
    public Director createDirector(@RequestBody Director director){return directorRepository.save(director);}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDirector(@PathVariable Long id, @RequestBody Director director){
        if (!directorRepository.existsById(id)){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Директор по id не найден");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        director.setId(id);
        directorRepository.save(director);
        return new ResponseEntity<>(directorRepository, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable Long id){
        if (!directorRepository.existsById(id)){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Директор по id не найден");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        directorRepository.deleteById(id);
        return new ResponseEntity<>(directorRepository, HttpStatus.OK);
    }
}
