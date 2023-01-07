package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.JobDomain;
import br.com.example.appjobs.dto.JobDTO;
import br.com.example.appjobs.mapper.JobMapper;
import br.com.example.appjobs.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {

    final JobRepository repository;
    final JobMapper mapper;

    public JobService(JobRepository repository, JobMapper mapper){

        this.repository = repository;
        this.mapper = mapper;
    }

    public JobDomain save(JobDTO dto){
        var object = mapper.fromEntity(dto);
        return repository.save(object);
    }

    public List<JobDomain> listAll(){
        return repository.findAll();
    }
}
