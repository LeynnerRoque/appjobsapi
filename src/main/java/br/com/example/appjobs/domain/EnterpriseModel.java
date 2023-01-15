package br.com.example.appjobs.domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "enterprise", schema = "appjobs", catalog = "")
public class EnterpriseModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "foundation_name", nullable = true, length = 200)
    private String foundationName;
    @Basic
    @Column(name = "email", nullable = true, length = 200)
    private String email;
    @Basic
    @Column(name = "phone_number", nullable = true, length = 11)
    private String phoneNumber;
    @OneToMany(mappedBy = "enterprise")
    private Collection<JobModel> jobsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoundationName() {
        return foundationName;
    }

    public void setFoundationName(String foundationName) {
        this.foundationName = foundationName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnterpriseModel that = (EnterpriseModel) o;

        if (id != that.id) return false;
        if (foundationName != null ? !foundationName.equals(that.foundationName) : that.foundationName != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (foundationName != null ? foundationName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    public Collection<JobModel> getJobsById() {
        return jobsById;
    }

    public void setJobsById(Collection<JobModel> jobsById) {
        this.jobsById = jobsById;
    }
}
