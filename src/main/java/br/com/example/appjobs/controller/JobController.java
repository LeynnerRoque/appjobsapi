package br.com.example.appjobs.controller;

import br.com.example.appjobs.domain.JobDomain;
import br.com.example.appjobs.dto.JobDTO;
import br.com.example.appjobs.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/job")
public class JobController {
    final JobService service;

    public JobController(JobService service){
        this.service = service;
    }

    @GetMapping("/api/all")
    public ResponseEntity<List<JobDTO>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
    }

}
