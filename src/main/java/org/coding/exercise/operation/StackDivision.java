package org.coding.exercise.operation;

import org.coding.exercise.common.StackOperationLog;

import java.util.Stack;

public class StackDivision implements StackOperation {

    public void run(Stack<Double> stack, Stack<StackOperationLog> stackOperationLogs) {
        if (stack.size() > 1) {
            double right = stack.pop();
            double left = stack.pop();
            double result = left / right;

            stack.push(result);
            stackOperationLogs.push(new StackOperationLog().withPushed(result).withPopped(right, left));
        } else
            throw new IllegalArgumentException("Not enough parameters");
    }
}
