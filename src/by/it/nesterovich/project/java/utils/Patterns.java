package by.it.nesterovich.project.java.utils;

public interface Patterns {
    String LOGIN = "\\w+";
    String EMAIL = "(\\w{2,})@([a-z]+\\.)([a-z]{2,4})";
    String PASSWORD = "\\w+";
    String FIRSTNAME = "[a-zA-Z]+";
    String LASTNAME = "[a-zA-Z]+";
    String PHONENUMBER = "[0-9]{8,12}";
}
