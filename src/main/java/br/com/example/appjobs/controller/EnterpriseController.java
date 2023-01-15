package br.com.example.appjobs.controller;

import br.com.example.appjobs.domain.EnterpriseModel;
import br.com.example.appjobs.dto.EnterpriseDTO;
import br.com.example.appjobs.mapper.EnterpriseMapper;
import br.com.example.appjobs.service.EnterpriseService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enterprise")
public class EnterpriseController {
    final EnterpriseService service;

    final EnterpriseMapper mapper;

    public EnterpriseController(EnterpriseService service, EnterpriseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/api/all")
    public ResponseEntity<List<EnterpriseDTO>> getAllEnterprise(){
        var dtos = mapper.toListDTO(service.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("/api/one/{id}")
    public ResponseEntity<EnterpriseDTO> getOneEnterprise(@PathVariable("id") Integer id){
        var dtos = mapper.toDTO(service.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/api/add")
    public ResponseEntity<EnterpriseModel> save(@RequestBody EnterpriseDTO a){
        return ResponseEntity.status(HttpStatus.OK).body(service.save(a));
    }


}
