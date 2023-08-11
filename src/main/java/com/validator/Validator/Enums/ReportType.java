package com.validator.Validator.Enums;

public enum ReportType {
    NEAR_MISS("Near Miss"),
    LOST_TIME("Lost Time"),
    FIRST_AID("First Aid");

    private final String label;

    ReportType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
