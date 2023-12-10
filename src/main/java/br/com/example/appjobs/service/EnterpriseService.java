package br.com.example.appjobs.service;

import br.com.example.appjobs.domain.EnterpriseModel;
import br.com.example.appjobs.dto.EnterpriseDTO;
import br.com.example.appjobs.mapper.EnterpriseMapper;
import br.com.example.appjobs.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<EnterpriseDTO> findAll(){
        return mapper.toListDTO(repository.findAll());
    }

    public EnterpriseDTO findById(Integer id){
        return mapper.toDTO(repository.findById(id));
    }

    @Transactional
    public EnterpriseDTO update(EnterpriseDTO dto){
        if(dto.getId() < 0){
            return null;
        }else{
            var object = mapper.fromEntity(dto);
            return mapper.toDTO(repository.save(object));
        }
    }

    @Transactional
    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new RuntimeException();
        }
    }

    public Page<EnterpriseDTO> lisPages(Pageable pageable){
        Page<EnterpriseDTO> pageDTO = mapper.toPageDTO(repository.findAll(pageable));
        return pageDTO;
    }


}
