package com.example.sortapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AppTest {
    private String[] input;
    private String expectedOutput;

    public AppTest(String[] input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"3", "1", "2"}, "[1, 2, 3]"},
                {new String[]{"9"}, "[9]"},
                {new String[]{}, "[]"},
                {new String[]{"10", "9", "8", "7", "6", "5", "4", "3", "2", "1"}, "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"},
        });
    }

    @Test
    public void testSortingApp() {
        assertEquals(expectedOutput, Arrays.toString(Arrays.stream(input).mapToInt(Integer::parseInt).sorted().toArray()));
    }
}
