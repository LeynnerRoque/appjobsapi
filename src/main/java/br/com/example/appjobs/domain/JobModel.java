package br.com.example.appjobs.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "job", schema = "appjobs", catalog = "")
public class JobModel {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "title", nullable = true, length = 100)
    private String title;
    @Basic
    @Column(name = "description", nullable = true, length = 100)
    private String description;
    @Basic
    @Column(name = "salary", nullable = true, precision = 0)
    private BigDecimal salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private List<PeoplesModel> peoplesList;
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EnterpriseModel enterpriseId;

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

    public EnterpriseModel getEnterprise() {
        return enterpriseId;
    }

    public void setEnterprise(EnterpriseModel enterprise) {
        this.enterpriseId = enterprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobModel jobModel = (JobModel) o;

        if (id != jobModel.id) return false;
        if (title != null ? !title.equals(jobModel.title) : jobModel.title != null) return false;
        if (description != null ? !description.equals(jobModel.description) : jobModel.description != null)
            return false;
        if (salary != null ? !salary.equals(jobModel.salary) : jobModel.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }
}
