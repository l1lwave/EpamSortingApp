package com.example.sortapp;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] numbers;

        if (args.length == 0) {
            System.out.println("Please enter up to 10 integers, separated by spaces:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] inputArgs = input.split("\\s+");
            scanner.close();
            numbers = parseInput(inputArgs);
        } else {
            numbers = parseInput(args);
        }

        if (numbers == null) {
            System.out.println("Please provide valid integers.");
            return;
        }

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static int[] parseInput(String[] inputArgs) {
        if (inputArgs.length > 10) {
            System.out.println("Please provide up to 10 integers.");
            return null;
        }

        int[] numbers = new int[inputArgs.length];
        try {
            for (int i = 0; i < inputArgs.length; i++) {
                numbers[i] = Integer.parseInt(inputArgs[i]);
            }
        } catch (NumberFormatException e) {
            return null;
        }

        return numbers;
    }
}
