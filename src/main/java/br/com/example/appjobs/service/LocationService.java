package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.LocationModel;
import br.com.example.appjobs.dto.LocationDTO;
import br.com.example.appjobs.mapper.LocationMapper;
import br.com.example.appjobs.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationService {

    final LocationRepository repository;
    final LocationMapper mapper;
    public LocationService(LocationRepository repository, LocationMapper mapper){

        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public LocationModel save(LocationDTO dto){
        int id =  (int) Math.random();
        dto.setId(id);
        var object = mapper.fromEntity(dto);
        return repository.save(object);
    }

    public List<LocationDTO> listAll(){
        var lista = repository.findAll();
        return mapper.toListDTO(lista);
    }

    public LocationDTO findById(Integer id){return  mapper.toDTO(repository.findById(id));}
}
