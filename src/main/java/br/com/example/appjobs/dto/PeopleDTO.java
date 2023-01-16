package br.com.example.appjobs.dto;

import br.com.example.appjobs.domain.JobModel;
import br.com.example.appjobs.domain.LocationModel;
import br.com.example.appjobs.domain.PeoplesModel;

public class PeopleDTO {

    public PeopleDTO(){}

    public PeopleDTO(PeoplesModel model){
        this.id = model.getId();
        this.name = model.getName();
        this.email = model.getEmail();
        this.gender = model.getGender();
        this.age = model.getAge();
        this.phone = model.getPhone();
        this.regionName = model.getRegionName();
        this.location = model.getLocation();
        this.job = model.getJob();
    }

    private int id;
    private String name;
    private String gender;
    private Integer age;
    private String regionName;
    private String email;

    private String phone;

    private Integer job;

    private Integer location;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
}
