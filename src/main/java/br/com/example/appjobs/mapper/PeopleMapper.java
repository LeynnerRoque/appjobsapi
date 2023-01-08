package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.PeopleDomain;
import br.com.example.appjobs.dto.PeopleDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PeopleMapper {

    public PeopleDomain fromEntity(PeopleDTO dto){
        var model = new PeopleDomain();
        BeanUtils.copyProperties(dto, model);
        return model;
    }
    public PeopleDTO toDTO(PeopleDomain model){
        var dto = new PeopleDTO(model);
        //BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public List<PeopleDTO> toListDTO(List<PeopleDomain> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
