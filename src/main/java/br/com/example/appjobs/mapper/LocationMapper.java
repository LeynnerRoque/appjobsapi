package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.LocationDomain;
import br.com.example.appjobs.dto.EnterpriseDTO;
import br.com.example.appjobs.dto.LocationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LocationMapper {

    public LocationDomain fromEntity(LocationDTO dto){
        var model = new LocationDomain();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public LocationDTO toDTO(LocationDomain model){
        var dto = new LocationDTO();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public List<LocationDTO> toListDTO(List<LocationDomain> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
