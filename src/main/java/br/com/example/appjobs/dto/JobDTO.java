package br.com.example.appjobs.dto;

import br.com.example.appjobs.domain.EnterpriseModel;
import br.com.example.appjobs.domain.JobModel;

public class JobDTO {


    public JobDTO(){
    }

    public JobDTO(JobModel model){
        this.id = model.getId();
        this.title = model.getTitle();
        this.description = model.getDescription();
        this.salary = model.getSalary();
        this.enterprise = new EnterpriseDTO(model.getEnterprise());
    }

    private int id;
    private String title;
    private String description;
    private Double salary;

    private EnterpriseDTO enterprise;

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

    public EnterpriseDTO getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseDTO enterprise) {
        this.enterprise = enterprise;
    }
}
