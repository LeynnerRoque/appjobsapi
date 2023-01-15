package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.EnterpriseModel;
import br.com.example.appjobs.dto.EnterpriseDTO;
import br.com.example.appjobs.mapper.EnterpriseMapper;
import br.com.example.appjobs.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    final EnterpriseRepository repository;
    final EnterpriseMapper mapper;

    public EnterpriseService(EnterpriseRepository repository, EnterpriseMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public EnterpriseModel save(EnterpriseDTO dto){
        int id = (int) Math.random();
        dto.setId(id);
        var object = mapper.fromEntity(dto);
        return repository.save(object);
    }

    public List<EnterpriseModel> findAll(){
        return repository.findAll();
    }

    public EnterpriseModel findById(Integer id){
        return repository.findById(id);
    }


}
