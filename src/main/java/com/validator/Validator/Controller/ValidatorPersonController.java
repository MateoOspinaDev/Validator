package com.validator.Validator.Controller;

import com.validator.Validator.Service.IValidatorPersonService;
import com.validator.Validator.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorPersonController {

    private final IValidatorPersonService validationService;

    @Autowired
    public ValidatorPersonController(IValidatorPersonService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/validate-person")
    public ResponseEntity<Boolean> validatePerson(@RequestBody Person person) {
        return new ResponseEntity<>(validationService.validatePerson(person), HttpStatus.OK);
    }
}
