package com.phoenix.isbntools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateISBN {

    public boolean checkISBN(String isbn) {

        Pattern pattern = Pattern.compile("^(0|[1-9][0-9]*)$");
        Matcher matcher = pattern.matcher(isbn);
        boolean matchFound = matcher.find();

        if (!matchFound) {
            throw new NumberFormatException("ISBN numbers must contain numbers only");
        }

        if (isbn.length() != 10) throw new NumberFormatException("ISBN numbers must be 10 digits long");

        int total = 0;

        for (int i = 0; i < 10; i++)
        {
            total += isbn.charAt(i) * (10 - i);
        }

        if (total % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
