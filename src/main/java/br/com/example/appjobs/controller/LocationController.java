package br.com.example.appjobs.controller;

import br.com.example.appjobs.domain.LocationModel;
import br.com.example.appjobs.dto.LocationDTO;
import br.com.example.appjobs.mapper.LocationMapper;
import br.com.example.appjobs.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/all")
    public ResponseEntity<List<LocationDTO>> ListAll(){
        var dtos = service.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/api/add")
    public ResponseEntity<LocationModel> save(@RequestBody LocationDTO dto){
        var saveObject = service.save(dto);
        if(saveObject != null){
            return ResponseEntity.status(HttpStatus.OK).body(saveObject);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //return ResponseEntity.status(HttpStatus.OK).body(service.save(dto));
    }

}
