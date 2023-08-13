package com.validator.Validator.Controller;

import com.validator.Validator.Dtos.ValidatorDto;
import com.validator.Validator.Service.IValidatorInjuryService;
import com.validator.Validator.Service.IValidatorPersonService;
import com.validator.Validator.models.Injury;
import com.validator.Validator.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {

    private final IValidatorInjuryService validationInjuryService;
    private final IValidatorPersonService validationPersonService;

    @Autowired
    public ValidatorController(IValidatorInjuryService validationInjuryService, IValidatorPersonService validationPersonService) {
        this.validationInjuryService = validationInjuryService;
        this.validationPersonService = validationPersonService;
    }

    @PostMapping("/api/validate-injury")
    public ResponseEntity<ValidatorDto> validateInjury(@RequestBody Injury injury) {
        ValidatorDto responseValidation = new ValidatorDto(validationInjuryService.validateInjury(injury));
        return new ResponseEntity<>(responseValidation, HttpStatus.OK);
    }

    @PostMapping("/api/validate-person")
    public ResponseEntity<ValidatorDto> validatePerson(@RequestBody Person person) {
        ValidatorDto responseValidation = new ValidatorDto(validationPersonService.validatePerson(person));
        return new ResponseEntity<>(responseValidation, HttpStatus.OK);
    }
}
