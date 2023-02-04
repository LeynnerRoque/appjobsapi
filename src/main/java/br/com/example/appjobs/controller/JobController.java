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
        try{
           return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @PostMapping("/api/add")
    public ResponseEntity<JobDTO> save(@RequestBody JobDTO dto){
        var a = service.save(dto);
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(a));
    }

    @GetMapping("{id}")
    public ResponseEntity<JobDTO> findById(@PathVariable("id") Integer id){
        var response = service.findById(id);
        if(response == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PutMapping("/api/up")
    public ResponseEntity<JobDTO> update(@RequestBody JobDTO dto){
        var a = service.update(dto);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }
}
