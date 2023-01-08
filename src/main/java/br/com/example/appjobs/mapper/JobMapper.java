package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.JobDomain;
import br.com.example.appjobs.dto.JobDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class JobMapper {

    public JobDomain fromEntity(JobDTO dto){
        var model = new JobDomain();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public JobDTO toDTO(JobDomain model){
        var dto = new JobDTO(model);
        //BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public List<JobDTO> toListDTO(List<JobDomain> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
