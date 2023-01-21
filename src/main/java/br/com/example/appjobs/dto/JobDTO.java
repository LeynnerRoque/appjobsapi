package br.com.example.appjobs.dto;

import br.com.example.appjobs.domain.EnterpriseModel;
import br.com.example.appjobs.domain.JobModel;

import java.math.BigDecimal;

public class JobDTO {


    public JobDTO(){
    }

    public JobDTO(JobModel model){
        this.id = model.getId();
        this.title = model.getTitle();
        this.description = model.getDescription();
        this.salary = model.getSalary();
        this.enterprise = model.getEnterprise().getId();
    }

    private int id;
    private String title;
    private String description;
    private BigDecimal salary;

    private Integer enterprise;

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Integer enterprise) {
        this.enterprise = enterprise;
    }
}
