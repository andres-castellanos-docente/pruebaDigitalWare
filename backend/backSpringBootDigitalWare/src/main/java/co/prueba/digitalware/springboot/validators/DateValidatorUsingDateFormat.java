package co.prueba.digitalware.springboot.validators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorUsingDateFormat implements DateValidator {
    private String dateFormat;

    public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String dateStr) {
        if ((dateStr.trim().length() <= 9) || (dateStr.trim().length() > 10)) {
            return false;
        }
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
