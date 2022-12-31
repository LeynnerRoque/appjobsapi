package br.com.example.appjobs.controller;

import br.com.example.appjobs.domain.EnterpriseDomain;
import br.com.example.appjobs.service.EnterpriseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enterprise")
public class EnterpriseController {
    final EnterpriseService service;

    public EnterpriseController(EnterpriseService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EnterpriseDomain>> getAllEnterprise(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }


    @PostMapping
    public ResponseEntity<EnterpriseDomain> save(@RequestBody EnterpriseDomain a){
        return ResponseEntity.status(HttpStatus.OK).body(service.save(a));
    }


}
