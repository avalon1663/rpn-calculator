package org.coding.exercise;

import org.coding.exercise.common.InsufficientParametersException;
import org.coding.exercise.service.ReversePolishNotionService;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalculatorApplication {

    private ReversePolishNotionService reversePolishNotionService;

    public CalculatorApplication(ReversePolishNotionService reversePolishNotionService) {
        this.reversePolishNotionService = reversePolishNotionService;
    }

    public static void main(String[] args) {
        Scanner scanner =
                new Scanner(System.in);
        CalculatorApplication calculatorApplication =
                new CalculatorApplication(new ReversePolishNotionService());
        while (scanner.hasNext()) {
            String input =
                    scanner.nextLine();
            calculatorApplication.processInput(input);
        }
    }

    public void processInput(String input) {
        Scanner scanner = new Scanner(
                new ByteArrayInputStream(input.getBytes()));
        int position = 0;

        while (scanner.hasNext()) {
            String command =
                    scanner.next();
            position += 1;
            try {
                this.reversePolishNotionService.parseCommand(command);
            } catch (InsufficientParametersException e) {
                System.err.println("operator " + command
                        + " (position: " + position + "): insufficient parameters");
                break;
            }
            position += 1;
        }
        System.out.println("stack: " + String.join(" ", this.getStackFormatted()));
    }

    public List<String> getStackFormatted() {
        return this.reversePolishNotionService().getStack().stream().map(each -> {
            BigDecimal bigDecimal =
                    new BigDecimal(each).setScale(10, RoundingMode.FLOOR);
            return String.valueOf(bigDecimal.doubleValue());
        }).collect(Collectors.toList());
    }

    public ReversePolishNotionService reversePolishNotionService() {
        return this.reversePolishNotionService;
    }
}
