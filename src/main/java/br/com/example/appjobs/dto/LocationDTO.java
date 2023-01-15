package br.com.example.appjobs.dto;

import br.com.example.appjobs.domain.LocationModel;

public class LocationDTO {

    public LocationDTO(){
    }

    public LocationDTO(LocationModel model){
        this.id = model.getId();
        this.city = model.getCity();
        this.postalCode = model.getPostalCode();
        this.stateProvince = model.getStateProvince();
        this.streetAddress = model.getStreetAddress();
    }

    private Integer id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
}
