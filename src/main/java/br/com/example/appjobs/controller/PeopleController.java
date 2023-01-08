package br.com.example.appjobs.controller;

import br.com.example.appjobs.dto.PeopleDTO;
import br.com.example.appjobs.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/people")
public class PeopleController {

    final PeopleService service;

    public PeopleController(PeopleService service){
        this.service = service;
    }

    @GetMapping("/api/all")
    public ResponseEntity<List<PeopleDTO>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
    }

}
