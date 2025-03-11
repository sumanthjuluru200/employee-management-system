package com.ems.fullstatck.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
public class EmployeeDTO {

//    private Long id;
//    private String name;
//    private String email;
//    private String city;
//
//    public EmployeeDTO() {
//    }
//
//    public EmployeeDTO(Long id, String name, String email, String city) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.city = city;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    @Override
//    public String toString() {
//        return "EmployeeDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", city='" + city + '\'' +
//                '}';
//    }

    private Long id;
    private String name;
    private String email;
    private String city;

    public EmployeeDTO() {
    }

    private EmployeeDTO(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.email=builder.email;
        this.city=builder.city;

    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private Long id;
        private String name;
        private String email;
        private String city;

        public Builder(){

        }

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;

        }

        public Builder city(String city){
            this.city=city;
            return this;
        }

        public EmployeeDTO build(){
            return new EmployeeDTO(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
