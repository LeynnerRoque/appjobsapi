package br.com.example.appjobs.controller;

import br.com.example.appjobs.dto.LocationDTO;
import br.com.example.appjobs.mapper.EnterpriseMapper;
import br.com.example.appjobs.mapper.LocationMapper;
import br.com.example.appjobs.service.EnterpriseService;
import br.com.example.appjobs.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/location")
public class LocationController {
    final LocationService service;
    final LocationMapper mapper;

    public LocationController(LocationService service, LocationMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }


    @GetMapping("/api/locations")
    public ResponseEntity<List<LocationDTO>> ListAll(){
        var dtos = service.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

}
