package com.validator.Validator.Enums;

public enum JobTitle {
    HAEMATOLOGIST("Haematologist"),
    PHYTOTHERAPIST("Phytotherapist"),
    BUILDING_SURVEYOR("Building surveyor"),
    INSURANCE_ACCOUNT_MANAGER("Insurance account manager"),
    EDUCATIONAL_PSYCHOLOGIST("Educational psychologist");

    private final String label;

    JobTitle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
