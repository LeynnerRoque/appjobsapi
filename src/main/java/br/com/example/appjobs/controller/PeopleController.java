package br.com.example.appjobs.controller;

import br.com.example.appjobs.dto.PeopleDTO;
import br.com.example.appjobs.mapper.PeopleMapper;
import br.com.example.appjobs.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/people")
public class PeopleController {

    final PeopleService service;
    final PeopleMapper mapper;

    public PeopleController(PeopleService service, PeopleMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/api/all")
    public ResponseEntity<List<PeopleDTO>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
    }

    @PostMapping("/api/add")
    public ResponseEntity<PeopleDTO> save(@RequestBody PeopleDTO dto){
        var object = service.save(dto);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(object));
    }
}
