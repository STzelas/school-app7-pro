package gr.aueb.cf.schoolapp.validator;

import gr.aueb.cf.schoolapp.dto.BaseDTO;

import java.util.HashMap;
import java.util.Map;

public class TeacherValidator<T> {
    private TeacherValidator() {}

    public static <T extends BaseDTO> Map<String, String> validate(T dto) {
        Map<String, String> errors = new HashMap<>();

        // Validation for character / digit length

        if (dto.getFirstname().length() < 2 || dto.getFirstname().length() > 32) {
            errors.put("firstname", "Firstname must be between 2 and 32 characters");
        }

        if (dto.getLastname().length() < 2 || dto.getFirstname().length() > 32) {
            errors.put("lastname", "Lastname must be between 2 and 32 characters");
        }

        if (dto.getVat().length() < 8 || dto.getFirstname().length() > 11) {
            errors.put("vat", "Vat must be between 8 and 11 characters");
        }

        if (dto.getFathername().length() < 2 || dto.getFirstname().length() > 32) {
            errors.put("fathername", "Fathername must be between 2 and 32 characters");
        }

        if (dto.getPhoneNum().length() < 7 || dto.getFirstname().length() > 12) {
            errors.put("phoneNum", "Phone number must be between 7 and 12 digits");
        }

        if (dto.getStreet().length() < 3 || dto.getFirstname().length() > 32) {
            errors.put("street", "Street must be between 7 and 12 characters");
        }

        if (dto.getStreetNum().length() < 1 || dto.getFirstname().length() > 5) {
            errors.put("streetNum", "Street number must be between 1 and 5 digits");
        }

        if (dto.getZipcode().length() < 5 || dto.getFirstname().length() > 9) {
            errors.put("zipcode", "Zipcode must be between 5 and 9 digits");
        }

        // Validation for white spaces

        if (dto.getFirstname().matches("^.*\\s+.*$")) {
            errors.put("firstname", "Firstname must not include spaces");
        }

        if (dto.getLastname().matches("^.*\\s+.*$")) {
            errors.put("lastname", "Lastname must not include spaces");
        }

        if (dto.getVat().matches("^.*\\s+.*$")) {
            errors.put("vat", "Vat must not include spaces");
        }

        if (dto.getFathername().matches("^.*\\s+.*$")) {
            errors.put("fathername", "Fathername must not include spaces");
        }

        if (dto.getEmail().matches("^.*\\s+.*$")) {
            errors.put("email", "Email must not include spaces");
        }

        if (dto.getPhoneNum().matches("^.*\\s+.*$")) {
            errors.put("phoneNum", "Phone numbers must not include spaces");
        }

        if (dto.getStreet().matches("^.*\\s+.*$")) {
            errors.put("street", "Street must not include spaces");
        }

        if (dto.getStreetNum().matches("^.*\\s+.*$")) {
            errors.put("streetNum", "Street number must not include spaces");
        }

        if (dto.getZipcode().matches("^.*\\s+.*$")) {
            errors.put("zipcode", "Zip code must not include spaces");
        }

//        // validate email
//
//        if (dto.getEmail().matches("\\w*\\.?\\w+\\w+\\.[a-z]{2,4}")) {
//            errors.put("email", "Email must contain '@'");
//        }

        return errors;
    }
}
