package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.EnterpriseDomain;
import br.com.example.appjobs.dto.EnterpriseDTO;
import br.com.example.appjobs.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnterpriseService {

    final EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public EnterpriseDomain save(EnterpriseDomain dto){
        double d = Math.random();
        long id = Double.doubleToLongBits(Math.random());
        dto.setId(id);
        return repository.save(dto);
    }

    public List<EnterpriseDomain> findAll(){
        return repository.findAll();
    }
}
