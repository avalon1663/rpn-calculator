package org.coding.exercise;

import org.coding.exercise.common.InsufficientParametersException;
import org.coding.exercise.common.OperationLog;
import org.coding.exercise.common.UnsupportedStackOperationException;
import org.coding.exercise.operation.*;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReversePolishNotionCalculator {

    private Stack<Double> stack = new Stack<>();
    private Stack<OperationLog> operationLogs = new Stack<>();

    public void parseCommandSequence(String sequence) {
        Scanner scanner = new Scanner(
                new ByteArrayInputStream(sequence.getBytes()));
        int position = 0;

        while (scanner.hasNext()) {
            String command =
                    scanner.next();
            position += 1;
            try {
                this.parseCommand(command);
            } catch (InsufficientParametersException e) {
                System.err.println("operator " + command
                        + " (position: " + position + "): insufficient parameters");
                break;
            }
            position += 1;
        }
        System.out.println("stack: " + String.join(" ", this.getStackFormatted()));
    }

    public void parseCommand(String command) throws InsufficientParametersException {
        try {
            StackOperation stackOperation =
                    this.resolveAsOperation(command);
            this.resolveStackOperation(stackOperation, this.stack, this.operationLogs);
        } catch (UnsupportedStackOperationException e) {
            this.resolveAsInput(command, this.stack, this.operationLogs);
        }
    }

    protected StackOperation resolveAsOperation(String command) throws UnsupportedStackOperationException {
        if ("+".equals(command)) {
            return new StackAddition();
        } else if ("-".equals(command)) {
            return new StackSubtraction();
        } else if ("*".equals(command)) {
            return new StackMultiplication();
        } else if ("/".equals(command)) {
            return new StackDivision();
        } else if ("sqrt".equalsIgnoreCase(command)) {
            return new StackSquareRoot();
        } else if ("undo".equalsIgnoreCase(command)) {
            return new StackUndo();
        } else if ("clear".equalsIgnoreCase(command)) {
            return new StackClear();
        } else
            throw new UnsupportedStackOperationException();
    }

    protected void resolveStackOperation(StackOperation stackOperation, Stack<Double> stack, Stack<OperationLog> operationLogs) throws InsufficientParametersException {
        stackOperation.run(stack, operationLogs);
    }

    protected void resolveAsInput(String command, Stack<Double> stack, Stack<OperationLog> operationLogs) {
        double number =
                Double.parseDouble(command);
        stack.push(number);

        operationLogs.push(new OperationLog().withPushed(number));
    }

    public Stack<Double> getStack() {
        return this.stack;
    }

    public List<String> getStackFormatted() {
        return this.stack.stream().map(each -> {
            BigDecimal bigDecimal =
                    new BigDecimal(each).setScale(10, RoundingMode.HALF_UP);
            return String.valueOf(bigDecimal.doubleValue());
        }).collect(Collectors.toList());
    }
}
