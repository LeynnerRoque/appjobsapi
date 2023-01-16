package br.com.example.appjobs.mapper;

import br.com.example.appjobs.domain.JobModel;
import br.com.example.appjobs.dto.JobDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class JobMapper {

    public JobModel fromEntity(JobDTO dto){
        if(dto.getTitle() == null){
            return null;
        }else{
            var model = new JobModel();
           // BeanUtils.copyProperties(dto, model);
            model.setId(dto.getId());
            model.setTitle(dto.getTitle());
            model.setDescription(dto.getDescription());
            model.setSalary(dto.getSalary());
            model.setEnterprise(dto.getEnterprise());
            return model;
        }
    }

    public JobDTO toDTO(JobModel model){
        var dto = new JobDTO(model);
        return dto;
    }

    public List<JobDTO> toListDTO(List<JobModel> models){
        return models.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
