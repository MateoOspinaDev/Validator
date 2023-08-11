package com.validator.Validator.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Injury {
    private String date;
    private String injuryLocation;
    private String location;
    private String Gender;
    private String ageGroup;
    private String incidentType;
    private String daysLost;
    private String plant;
    private String reportType;
    private String shift;
    private String department;
    private String incidentCost;
    private String wkDay;
    private String month;
    private String year;
}
