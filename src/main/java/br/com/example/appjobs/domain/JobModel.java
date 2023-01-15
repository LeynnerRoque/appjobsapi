package br.com.example.appjobs.domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "job", schema = "appjobs", catalog = "")
public class JobModel {
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
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id", nullable = false)
    private EnterpriseModel enterprise;
    @OneToMany(mappedBy = "jobByJobId")
    private Collection<PeoplesModel> peoplesById;

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

    public EnterpriseModel getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseModel enterpriseByEnterpriseId) {
        this.enterprise = enterpriseByEnterpriseId;
    }

    public Collection<PeoplesModel> getPeoplesById() {
        return peoplesById;
    }

    public void setPeoplesById(Collection<PeoplesModel> peoplesById) {
        this.peoplesById = peoplesById;
    }
}
