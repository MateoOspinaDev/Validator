package com.validator.Validator.Service;

import com.validator.Validator.Enums.JobTitle;
import com.validator.Validator.models.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidatorPersonService implements IValidatorPersonService {

    public boolean validatePerson(Person person) {
        boolean validation = validateEmail(person.getEmail())
                && validateDateOfBirth(person.getDateOfBirth())
                && validateJobTitle(person.getJobTitle());
        if (!validation) {
            if (!validateEmail(person.getEmail())) {
                System.out.println("Correo inválido: " + person.getEmail());
            }
            if (!validateDateOfBirth(person.getDateOfBirth())) {
                System.out.println("Fecha de nacimiento inválida: " + person.getDateOfBirth());
            }
            if (!validateJobTitle(person.getJobTitle())) {
                System.out.println("Título de trabajo inválido: " + person.getJobTitle());
            }
        }
        return validation;
    }

    public boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateDateOfBirth(LocalDate dateOfBirth) {
        LocalDate minValidDate = LocalDate.of(1980, 1, 1);
        return dateOfBirth.isAfter(minValidDate);
    }

    public boolean validateJobTitle(String jobTitle) {
        return Arrays.stream(JobTitle.values())
                .anyMatch(validJobTitle -> jobTitle.contains(validJobTitle.getLabel()));
    }

}
