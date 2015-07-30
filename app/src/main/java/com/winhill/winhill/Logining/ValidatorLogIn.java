package com.winhill.winhill.Logining;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by apple on 30.07.15.
 */
public class ValidatorLogIn {
    Matcher matcher;
    Pattern patternPassword, patternEmail;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{6,40})";

    public ValidatorLogIn(){
        patternPassword = Pattern.compile(PASSWORD_PATTERN);
        patternEmail = Pattern.compile(EMAIL_PATTERN);
    }



    public boolean isValidEmail(final String email) {

        matcher = patternEmail.matcher(email);
        return matcher.matches();
    }



    public boolean isValidPassword(final String password) {

        matcher = patternPassword.matcher(password);
        return matcher.matches();

    }

}
