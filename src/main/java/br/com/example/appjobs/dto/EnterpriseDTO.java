package br.com.example.appjobs.dto;

import br.com.example.appjobs.domain.EnterpriseDomain;
import jakarta.validation.constraints.NotBlank;

public class EnterpriseDTO {
    @NotBlank
    private String foundationName;
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;


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
