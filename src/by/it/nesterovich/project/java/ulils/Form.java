package by.it.nesterovich.project.java.ulils;

import java.text.ParseException;

public class Form {

    public static String getString(String value, String regexPattern) throws ParseException {
        if (value.trim().matches(regexPattern)) {
            return value;
        } else {
            throw new ParseException("Input error: " + value, 1);
        }
    }
}
