package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.PeoplesModel;
import br.com.example.appjobs.dto.PeopleDTO;
import br.com.example.appjobs.mapper.PeopleMapper;
import br.com.example.appjobs.repository.JobRepository;
import br.com.example.appjobs.repository.LocationRepository;
import br.com.example.appjobs.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    final PeopleRepository repository;
    final PeopleMapper mapper;

    final JobRepository jobRepository;
    final LocationRepository locationRepository;

    public PeopleService(
            PeopleRepository repository,
            PeopleMapper mapper,
            JobRepository jobRepository,
            LocationRepository locationRepository) {

        this.repository = repository;
        this.mapper = mapper;
        this.jobRepository = jobRepository;
        this.locationRepository = locationRepository;
    }

    public PeoplesModel save(PeopleDTO dto) {
        var object = mapper.fromEntity(dto);
        var jbo = jobRepository.findById(dto.getJob());
        var lct = locationRepository.findById(dto.getLocation());
        if(jbo != null && lct != null){
            object.setJob(jbo);
            object.setLocation(lct);
            return repository.save(object);
        }
        return null;
    }

    public List<PeopleDTO> listAll() {
        return mapper.toListDTO(repository.findAll());
    }
}
