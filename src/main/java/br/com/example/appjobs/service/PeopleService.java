package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.JobModel;
import br.com.example.appjobs.domain.PeoplesModel;
import br.com.example.appjobs.dto.PeopleDTO;
import br.com.example.appjobs.mapper.PeopleMapper;
import br.com.example.appjobs.repository.JobRepository;
import br.com.example.appjobs.repository.LocationRepository;
import br.com.example.appjobs.repository.PeopleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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

    public PeopleDTO findById(Integer id){
        return mapper.toDTO(repository.findById(id));
    }

    @Transactional
    public PeopleDTO update(PeopleDTO dto){
        if(dto.getId() < 0){
            return null;
        }else{
            return mapper.toDTO(save(dto));
        }
    }

    public List<PeopleDTO> findPeoplesByJobId(Integer id){
        List<PeopleDTO> dtos = mapper.toListDTO(repository.findPeoplesByJobID(id));
        return dtos;
    }

    public List<PeopleDTO> findPeoplesByLocationId(Integer id){
        List<PeopleDTO> dtos = mapper.toListDTO(repository.findPeoplesByLocationId(id));
        return dtos;
    }

    public Page<PeopleDTO> pages(Pageable pageable){
        return mapper.toPageDTO(repository.findAll(pageable));
    }

    @Transactional
    public void delete(Long id){
        if(repository.existsById(id)){
           repository.deleteById(id);
        }
    }

    public PeopleDTO filterByName(String name){
        return mapper.toDTO(repository.findPeoplesModelByName(name));
    }

    public List<PeopleDTO> filterByJobTitle(String title){
        var job = jobRepository.findJobModelsByTitle(title);
        List<PeoplesModel> lista = repository.findPeoplesByJobID(job.getId());
        return mapper.toListDTO(lista);
    }
}
