package com.example.proyectbiblioteca.controllers;

import com.example.proyectbiblioteca.dto.autor.AutorDTO;
import com.example.proyectbiblioteca.dto.autor.RequestAutorDTO;
import com.example.proyectbiblioteca.dto.autor.ErrorAutorDTO;
import com.example.proyectbiblioteca.mappers.AuthorMapper;
import com.example.proyectbiblioteca.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/autors")
public class AutorRestController {

    @Autowired
    private AutorService autorService;
    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping("/")
    public ResponseEntity<List<AutorDTO>> getAllAutors() {
        try {
            return ResponseEntity.ok(new ArrayList<>(autorService.getAllAutor()));
        } catch (Exception e) {
            List<AutorDTO> autorDTOS = new ArrayList<>();
            autorDTOS.add(new ErrorAutorDTO(e.getMessage()));
            return new ResponseEntity<>(autorDTOS, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> getAutor(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(autorService.getAutor(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorAutorDTO(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<AutorDTO> saveAutor(@RequestBody RequestAutorDTO autor) {
        try {
            return new ResponseEntity<>(autorService.saveAutor(authorMapper.toAutorData(autor)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorAutorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> updateAutor(@RequestBody RequestAutorDTO autor, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(autorService.updateAutor(authorMapper.toAutorData(autor), id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorAutorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AutorDTO> deleteAutor(@PathVariable Long id) {
        try {
            autorService.deleteAutor(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorAutorDTO(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
