package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.PeoplesModel;
import br.com.example.appjobs.dto.PeopleDTO;
import br.com.example.appjobs.mapper.PeopleMapper;
import br.com.example.appjobs.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    final PeopleRepository repository;
    final PeopleMapper mapper;

    public PeopleService(PeopleRepository repository, PeopleMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    public PeoplesModel save(PeopleDTO dto) {
        var object = mapper.fromEntity(dto);
        return repository.save(object);
    }

    public List<PeopleDTO> listAll() {
        var lista = mapper.toListDTO(repository.findAll());
        return lista;
    }
}
