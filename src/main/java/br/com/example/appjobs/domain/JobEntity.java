package br.com.example.appjobs.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "job", schema = "appjobs", catalog = "")
public class JobEntity {
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
    @JoinColumn(name = "enterprise_id", nullable = false)
    private EnterpriseEntity enterpriseId;

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

    public EnterpriseEntity getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(EnterpriseEntity enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobEntity jobEntity = (JobEntity) o;

        if (id != jobEntity.id) return false;
        if (enterpriseId != jobEntity.enterpriseId) return false;
        if (title != null ? !title.equals(jobEntity.title) : jobEntity.title != null) return false;
        if (description != null ? !description.equals(jobEntity.description) : jobEntity.description != null)
            return false;
        if (salary != null ? !salary.equals(jobEntity.salary) : jobEntity.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
