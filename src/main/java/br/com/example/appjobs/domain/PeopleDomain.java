package br.com.example.appjobs.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "peoples")
public class PeopleDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String regionName;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn
    private JobDomain jobId;

    @OneToOne
    @JoinColumn
    private LocationDomain locationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public JobDomain getJobId() {
        return jobId;
    }

    public void setJobId(JobDomain jobId) {
        this.jobId = jobId;
    }

    public LocationDomain getLocationId() {
        return locationId;
    }

    public void setLocationId(LocationDomain locationId) {
        this.locationId = locationId;
    }


}
