package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.LocationModel;
import br.com.example.appjobs.dto.LocationDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LocationMapper {

    public LocationModel fromEntity(LocationDTO dto){
        var model = new LocationModel();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public LocationDTO toDTO(LocationModel model){
        var dto = new LocationDTO(model);
        //BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public List<LocationDTO> toListDTO(List<LocationModel> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Page<LocationDTO> toPageDTO(Page<LocationModel> pagesList){
        List<LocationDTO> pages = toListDTO(pagesList.toList());
        return new PageImpl<>(pages);
    }
}
