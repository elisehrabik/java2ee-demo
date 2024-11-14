package edu.kirkwood.shared;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static boolean isANumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Source: Google Gemini
    public static boolean isValidEmail(String email) {
        // https://chatgpt.com/share/67354b3b-fe64-8006-9ff3-35f5346d7aec
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
