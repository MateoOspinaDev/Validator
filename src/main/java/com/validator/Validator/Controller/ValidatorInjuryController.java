package com.validator.Validator.Controller;

import com.validator.Validator.Service.IValidatorInjuryService;
import com.validator.Validator.models.Injury;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorInjuryController {

    private final IValidatorInjuryService validationService;

    @Autowired
    public ValidatorInjuryController(IValidatorInjuryService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/validate-injury")
    public ResponseEntity<Boolean> validateInjury(@RequestBody Injury injury) {
        return new ResponseEntity<>(validationService.validateInjury(injury), HttpStatus.OK);
    }
}
