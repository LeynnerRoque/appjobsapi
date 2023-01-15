package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.PeoplesModel;
import br.com.example.appjobs.dto.PeopleDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PeopleMapper {

    public PeoplesModel fromEntity(PeopleDTO dto){
        var model = new PeoplesModel();
        BeanUtils.copyProperties(dto, model);
        return model;
    }
    public PeopleDTO toDTO(PeoplesModel model){
        var dto = new PeopleDTO(model);
        //BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public List<PeopleDTO> toListDTO(List<PeoplesModel> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
