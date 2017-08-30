package com.draganlj.survey.capture.model;

import lombok.Data;

import java.util.Date;

@Data
public class RegistredUser implements User {

    private String uniqueId;
    private String userName;
    private String userEmail;
    private String fullName;
    private String gender;
    private Date dateOfBirth;
    private String address;

}
