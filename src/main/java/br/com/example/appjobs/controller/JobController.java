package br.com.example.appjobs.controller;

import br.com.example.appjobs.dto.JobDTO;
import br.com.example.appjobs.mapper.JobMapper;
import br.com.example.appjobs.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/job")
public class JobController {
    final JobService service;
    final JobMapper mapper;

    public JobController(JobService service, JobMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/api/all")
    public ResponseEntity<List<JobDTO>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
    }

    @PostMapping("/api/add")
    public ResponseEntity<JobDTO> save(@RequestBody JobDTO dto){
        var a = service.save(dto);
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(a));

    }
}
