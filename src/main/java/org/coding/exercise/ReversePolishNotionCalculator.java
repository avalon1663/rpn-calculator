package org.coding.exercise;

import org.coding.exercise.common.InsufficientParametersException;
import org.coding.exercise.common.OperationLog;
import org.coding.exercise.common.UnsupportedStackOperationException;
import org.coding.exercise.operation.*;

import java.util.Stack;

public class ReversePolishNotionCalculator {

    private Stack<Double> stack = new Stack<>();
    private Stack<OperationLog> operationLogs = new Stack<>();

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
}
