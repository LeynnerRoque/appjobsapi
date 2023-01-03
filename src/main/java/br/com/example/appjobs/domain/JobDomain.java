package br.com.example.appjobs.domain;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "job")
public class JobDomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
     private Double salary;

    @OneToOne
    @JoinColumn
    private EnterpriseDomain enterpriseId;


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

    public EnterpriseDomain getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(EnterpriseDomain enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
