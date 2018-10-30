package com.startupnationgo.blooddonationapp.models;

public class Model {
    String name, bloodGroup,mobile,hospitalAdress,landMark,token;

    public Model(String name,String bloodGroup,String mobile,String hospitalAdress,String landMark,String token){
        this.name=name;
        this.bloodGroup=bloodGroup;
        this.mobile=mobile;
        this.hospitalAdress=hospitalAdress;
        this.landMark=landMark;
        this.token=token;

    }

    public Model() {
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHospitalAdress() {
        return hospitalAdress;
    }

    public void setHospitalAdress(String hospitalAdress) {
        this.hospitalAdress = hospitalAdress;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
