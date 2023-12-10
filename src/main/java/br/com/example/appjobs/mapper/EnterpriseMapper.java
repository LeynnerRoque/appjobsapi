package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.EnterpriseModel;
import br.com.example.appjobs.dto.EnterpriseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EnterpriseMapper {

    public EnterpriseModel fromEntity(EnterpriseDTO dto){
        var model = new EnterpriseModel();
        BeanUtils.copyProperties(dto, model);
        return model;
    }


    public EnterpriseDTO toDTO(EnterpriseModel model){
        var dto = new EnterpriseDTO(model);
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public List<EnterpriseDTO> toListDTO(List<EnterpriseModel> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Page<EnterpriseDTO> toPageDTO(Page<EnterpriseModel> pageModelList){
        List<EnterpriseDTO> pages = toListDTO(pageModelList.toList());
        return new PageImpl<EnterpriseDTO>(pages);
    }
}
