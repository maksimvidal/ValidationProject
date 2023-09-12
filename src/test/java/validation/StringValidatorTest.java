package validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringValidatorTest {

    private final int length = 5;

    StringValidator underTest = new StringValidator();

    @Test
    void testInputMatchesLength() {
        String input = "Aa1!7"; // 5 characters
        assertTrue(underTest.isValid(input, length));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Aa1 !", "Aab!!", "Aa123", "a12!7", "A12!7",  "Aa1!", "Aa1!78"})
    void shouldFailWhenStringIsInvalid(String invalidString) {
        assertFalse(underTest.isValid(invalidString, length));
    }
}
