package br.com.example.appjobs.dto;

public class JobDTO {
    private String title;
    private String description;
    private Double salary;

    private EnterpriseDTO enterpriseDTO;


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

    public EnterpriseDTO getEnterpriseDTO() {
        return enterpriseDTO;
    }

    public void setEnterpriseDTO(EnterpriseDTO enterpriseDTO) {
        this.enterpriseDTO = enterpriseDTO;
    }
}
