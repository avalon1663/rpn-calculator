package org.coding.exercise.operation;

import org.coding.exercise.common.StackOperationLog;

import java.util.Stack;

public class StackSquareRoot implements StackOperation {

    public void run(Stack<Double> stack, Stack<StackOperationLog> stackOperationLogs) {
        if (stack.size() > 0) {
            double value = stack.pop();
            double result = Math.sqrt(value);

            stack.push(result);
            stackOperationLogs.push(new StackOperationLog().withPushed(result).withPopped(value));
        } else
            throw new IllegalArgumentException("Not enough parameters");
    }
}
