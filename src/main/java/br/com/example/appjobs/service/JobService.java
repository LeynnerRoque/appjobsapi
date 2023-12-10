package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.JobModel;
import br.com.example.appjobs.dto.JobDTO;
import br.com.example.appjobs.mapper.EnterpriseMapper;
import br.com.example.appjobs.mapper.JobMapper;
import br.com.example.appjobs.repository.EnterpriseRepository;
import br.com.example.appjobs.repository.JobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        var object = mapper.fromEntity(dto);
        var enterprise = enterpriseRepository.findById(dto.getEnterprise());
        if(enterprise != null){
            object.setEnterprise(enterprise);
        }
        return repository.save(object);
    }

    public List<JobDTO> listAll() {
        var lista = mapper.toListDTO(repository.findAll());
        return lista;
    }

    public JobDTO findById(Integer id){
        Long valor = id.longValue();
        return mapper.toDTO(repository.findById(valor).get());
    }

    public JobDTO update(JobDTO dto){
        if(dto.getId() < 0){
            return null;
        }else{
            var object = mapper.fromEntity(dto);
            var enterprise = enterpriseRepository.findById(dto.getEnterprise());
            if(enterprise != null){
                object.setEnterprise(enterprise);
            }
            return mapper.toDTO(save(dto));
        }

    }

    public List<JobDTO> findbyEnterpriseId(Integer id){
        List<JobDTO> dtos = mapper.toListDTO(repository.findJobsByIdEnterprise(id));
        return dtos;
    }

    public JobDTO findByTitle(String title){
        return mapper.toDTO(repository.findJobModelsByTitle(title));
    }

    public Page<JobDTO> pages(Pageable pageable){
        return mapper.toPageDTO(repository.findAll(pageable));
    }
}
