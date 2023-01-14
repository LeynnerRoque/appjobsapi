package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.JobEntity;
import br.com.example.appjobs.dto.JobDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class JobMapper {

    public JobEntity fromEntity(JobDTO dto){
        var model = new JobEntity();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public JobDTO toDTO(JobEntity model){
        var dto = new JobDTO(model);
        //BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public List<JobDTO> toListDTO(List<JobEntity> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
