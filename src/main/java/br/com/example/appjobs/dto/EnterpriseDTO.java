package br.com.example.appjobs.dto;

import br.com.example.appjobs.domain.EnterpriseModel;
import jakarta.validation.constraints.NotBlank;

public class EnterpriseDTO {

    private int id;
    @NotBlank
    private String foundationName;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;


    public EnterpriseDTO(EnterpriseModel model){
        this.id = model.getId();
        this.foundationName = model.getFoundationName();
        this.email = model.getEmail();
        this.phoneNumber = model.getPhoneNumber();
    }

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

}
