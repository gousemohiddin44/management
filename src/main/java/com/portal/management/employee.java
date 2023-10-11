package com.portal.management;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;


@Data
@Entity
@Table(name = "employee")
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String fullName;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private workInfo workInformation;
}

@Data
class workInfo {

    @Id
    private Integer employeeId;
    private String employmentType;
    private String department;
    private String designation;
    private String location;
    private String employeeStatus;
    private String dateOfJoining;
}