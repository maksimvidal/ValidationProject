package validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringValidatorTest {

    private final int length = 5;

    @Test
    void testInputExceedsLength() {
        String input = "Aa1!78"; // 6 characters
        assertFalse(StringValidator.isValid(input, length));
    }

    @Test
    void testStringLengthSmallerThenProvided() {
        String input = "Aa1!"; // 4 characters
        assertFalse(StringValidator.isValid(input, length));
    }

    @Test
    void testInputMatchesLength() {
        String input = "Aa1!7"; // 5 characters
        assertTrue(StringValidator.isValid(input, length));
    }

    @Test
    void testMissingLowercaseLetter() {
        String input = "A12!7";
        assertFalse(StringValidator.isValid(input, length));
    }

    @Test
    void testMissingUppercaseLetter() {
        String input = "a12!7";
        assertFalse(StringValidator.isValid(input, length));
    }

    @Test
    void testMissingSpecialCharacter() {
        String input = "Aa123";
        assertFalse(StringValidator.isValid(input, length));
    }

    @Test
    void testMissingDigit() {
        String input = "Aab!!";
        assertFalse(StringValidator.isValid(input, length));
    }

    @Test
    void testExcessWhitespace() {
        String input = "Aa1 !";
        assertFalse(StringValidator.isValid(input, length));
    }
}
