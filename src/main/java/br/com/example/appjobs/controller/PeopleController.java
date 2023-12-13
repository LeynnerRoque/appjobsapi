package br.com.example.appjobs.controller;

import br.com.example.appjobs.dto.PeopleDTO;
import br.com.example.appjobs.mapper.PeopleMapper;
import br.com.example.appjobs.service.PeopleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.listAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/api/findByJob/{id}")
    public ResponseEntity<List<PeopleDTO>> findPeoplesByJobId(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findPeoplesByJobId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/api/findByLocal/{id}")
    public ResponseEntity<List<PeopleDTO>> findPeoplesByLocal(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findPeoplesByLocationId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/api/add")
    public ResponseEntity<PeopleDTO> save(@RequestBody PeopleDTO dto){
        try {
            var object = service.save(dto);
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(object));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<PeopleDTO> findById(@PathVariable("id") Integer id){
        var response = service.findById(id);
        if(response == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PutMapping("/api/up")
    public ResponseEntity<PeopleDTO> uodate(@RequestBody PeopleDTO dto){
        try{
            var object = service.update(dto);
            return ResponseEntity.status(HttpStatus.OK).body(object);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<PeopleDTO>> pages(@PageableDefault(page = 0,size = 2, sort = "name")Pageable pageable){
        return ResponseEntity.ok(service.pages(pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok("Remove");
    }
}
