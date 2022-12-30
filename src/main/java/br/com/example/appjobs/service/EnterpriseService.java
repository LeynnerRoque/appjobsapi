package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.EnterpriseDomain;
import br.com.example.appjobs.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    final EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository) {
        this.repository = repository;
    }

    public List<EnterpriseDomain> findAll(){
        return repository.findAll();
    }
}
