package br.com.example.appjobs.dto;

import br.com.example.appjobs.domain.EnterpriseEntity;
import br.com.example.appjobs.domain.JobEntity;

public class JobDTO {


    public JobDTO(){
    }

    public JobDTO(JobEntity model){
        this.id = model.getId();
        this.title = model.getTitle();
        this.description = model.getDescription();
        this.salary = model.getSalary();
        this.enterprise = model.getEnterpriseId();
    }

    private int id;
    private String title;
    private String description;
    private Double salary;

    private EnterpriseEntity enterprise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public EnterpriseEntity getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseEntity enterprise) {
        this.enterprise = enterprise;
    }
}
