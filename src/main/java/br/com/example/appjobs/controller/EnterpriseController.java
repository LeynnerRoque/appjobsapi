package br.com.example.appjobs.controller;

import br.com.example.appjobs.domain.EnterpriseModel;
import br.com.example.appjobs.dto.EnterpriseDTO;
import br.com.example.appjobs.service.EnterpriseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enterprise")
public class EnterpriseController {
    final EnterpriseService service;

    public EnterpriseController(EnterpriseService service) {
        this.service = service;
    }

    @GetMapping("/api/all")
    public ResponseEntity<List<EnterpriseDTO>> getAllEnterprise(){
        var dtos = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("/api/one/{id}")
    public ResponseEntity<EnterpriseDTO> getOneEnterprise(@PathVariable("id") Integer id){
        var dtos = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/api/add")
    public ResponseEntity<EnterpriseModel> save(@RequestBody EnterpriseDTO a){
        return ResponseEntity.status(HttpStatus.OK).body(service.save(a));
    }

    @PutMapping("/api/up")
    public ResponseEntity<EnterpriseDTO> update(@RequestBody EnterpriseDTO a){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(a));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allpages")
    public ResponseEntity<Page<EnterpriseDTO>> pages(@PageableDefault(page = 0, size = 2, sort = "foundationName") Pageable pageable){
        return ResponseEntity.ok(service.listPages(pageable));
    }

    @GetMapping("/filterName/{name}")
    public ResponseEntity<EnterpriseDTO> filterByName(@PathVariable("name") String name){
        return ResponseEntity.ok(service.filterByName(name));
    }

}
