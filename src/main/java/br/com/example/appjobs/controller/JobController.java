package br.com.example.appjobs.controller;

import br.com.example.appjobs.dto.JobDTO;
import br.com.example.appjobs.mapper.JobMapper;
import br.com.example.appjobs.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/job")
public class JobController {
    final JobService service;
    final JobMapper mapper;

    private final Logger log = LoggerFactory.getLogger(JobController.class);

    public JobController(JobService service, JobMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/api/all")
    public ResponseEntity<List<JobDTO>> listAll(){
        try{
            log.debug("Entrou no ListAll");
           return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
        }catch (Exception e){
            log.error("Algo deu errado na requisicao: "+e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/api/findby/{id}")
    public ResponseEntity<List<JobDTO>> findByEnterprise(@PathVariable("id") Integer id){
        try{
            log.debug("entrou na busca por id de Enterprise");
            return ResponseEntity.status(HttpStatus.OK).body(service.findbyEnterpriseId(id));
        }catch (Exception e){
            log.error("Algo deu errado na requisicao: "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @GetMapping("/api/findTitle/{title}")
    public ResponseEntity<JobDTO> findByTitle(@PathVariable("title") String title){
        try{
            log.debug("entrou na busca por Title");
            return ResponseEntity.status(HttpStatus.OK).body(service.findByTitle(title));
        }catch (Exception e){
            log.error("Algo deu errado na requisicao: "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/api/add")
    public ResponseEntity<JobDTO> save(@RequestBody JobDTO dto){
        try{
            log.debug("Entrou no add");
            var a = service.save(dto);
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(a));
        }catch (Exception e){
            log.error("Algo deu errado na requisicao: "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<JobDTO> findById(@PathVariable("id") Integer id){
        var response = service.findById(id);
        if(response == null){
            log.info("Algo deu errado na requisicao, objeto null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else{
            log.debug("Entrou no find por id: {}"+id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PutMapping("/api/up")
    public ResponseEntity<JobDTO> update(@RequestBody JobDTO dto){
        try{
            log.debug("Entrou para atualizar o objeto");
            var a = service.update(dto);
            return ResponseEntity.status(HttpStatus.OK).body(a);
        }catch (Exception e){
            log.error("Algo deu errado na requisicao: "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<JobDTO>> pages(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(service.pages(pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok("Remove");
    }

    @GetMapping("/filterByNameFoundation/{name}")
    public  ResponseEntity filterByName(@PathVariable("name") String name){
        return ResponseEntity.ok(service.filterByEnterpriseName(name));
    }
}
