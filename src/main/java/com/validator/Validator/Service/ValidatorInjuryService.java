package com.validator.Validator.Service;

import com.validator.Validator.Enums.ReportType;
import com.validator.Validator.models.Injury;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ValidatorInjuryService implements IValidatorInjuryService {
    @Override
    public boolean validateInjury(Injury injury) {
        return validateInjuryLocation(injury.getInjuryLocation())
                && validateReportType(injury.getReportType());
    }

    public boolean validateInjuryLocation(String injuryLocation) {
        String noAplica = "N/A";
        return !noAplica.equals(injuryLocation);
    }

    public boolean validateReportType(String reportType) {
        return Arrays.stream(ReportType.values())
                .anyMatch(validJobTitle -> validJobTitle.getLabel().equals(reportType));
    }
}
