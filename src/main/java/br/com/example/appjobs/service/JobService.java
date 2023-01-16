package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.EnterpriseModel;
import br.com.example.appjobs.domain.JobModel;
import br.com.example.appjobs.dto.JobDTO;
import br.com.example.appjobs.mapper.EnterpriseMapper;
import br.com.example.appjobs.mapper.JobMapper;
import br.com.example.appjobs.repository.EnterpriseRepository;
import br.com.example.appjobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {

    final JobRepository repository;
    final JobMapper mapper;

    final EnterpriseRepository enterpriseRepository;
    final EnterpriseMapper enterpriseMapper;

    public JobService(JobRepository repository,
                      JobMapper mapper,
                      EnterpriseRepository enterpriseRepository,
                      EnterpriseMapper enterpriseMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.enterpriseRepository = enterpriseRepository;
        this.enterpriseMapper = enterpriseMapper;
    }

    public JobModel save(JobDTO dto) {
            int id = (int) Math.random();
            dto.setId(id);
            var object = mapper.fromEntity(dto);
            return repository.save(object);
    }

    public List<JobDTO> listAll() {
        var lista = mapper.toListDTO(repository.findAll());
        return lista;
    }
}
