package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.EnterpriseDomain;
import br.com.example.appjobs.dto.EnterpriseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EnterpriseMapper {

    public EnterpriseDomain fromEntity(EnterpriseDTO dto){
        var model = new EnterpriseDomain();
        BeanUtils.copyProperties(dto, model);
        return model;
    }


    public EnterpriseDTO toDTO(EnterpriseDomain model){
        var dto = new EnterpriseDTO();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public List<EnterpriseDTO> toListDTO(List<EnterpriseDomain> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }



}