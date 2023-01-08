package br.com.example.appjobs.dto;

import br.com.example.appjobs.domain.EnterpriseDomain;
import br.com.example.appjobs.domain.JobDomain;

public class JobDTO {


    public JobDTO(){
    }

    public JobDTO(JobDomain model){
        this.id = model.getId();
        this.title = model.getTitle();
        this.description = model.getDescription();
        this.salary = model.getSalary();
        this.enterprise = model.getEnterpriseId();
    }

    private Long id;
    private String title;
    private String description;
    private Double salary;

    private Long enterprise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Long enterprise) {
        this.enterprise = enterprise;
    }
}
