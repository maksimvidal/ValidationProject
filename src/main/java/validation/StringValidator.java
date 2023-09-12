package validation;

import java.util.regex.Pattern;

public class StringValidator {

    private static final String SPECIAL_CHARS = "!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~";

    /**
     * Validates the string based on the provided length and certain criteria.
     *
     * @param s        The string to be validated.
     * @param length   The expected length of the string.
     * @return         true if the string meets the criteria, false otherwise.
     */
    public static boolean isValid(String s, int length) {
        // Regular expression to check the criteria
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[" + Pattern.quote(SPECIAL_CHARS) + "])[^\\s]{" + length + "}$";

        return s.matches(regex);
    }
}
