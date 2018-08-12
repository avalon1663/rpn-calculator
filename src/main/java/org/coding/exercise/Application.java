package org.coding.exercise;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner =
                new Scanner(System.in);
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        while (scanner.hasNext()) {
            String sequence =
                    scanner.nextLine();
            calculator.parseCommandSequence(sequence);
        }
    }
}
