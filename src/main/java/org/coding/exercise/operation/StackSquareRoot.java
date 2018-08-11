package org.coding.exercise.operation;

import org.coding.exercise.common.InsufficientParametersException;
import org.coding.exercise.common.OperationLog;

import java.util.Stack;

public class StackSquareRoot implements StackOperation {

    public void run(Stack<Double> stack, Stack<OperationLog> operationLogs) throws InsufficientParametersException {
        if (stack.size() > 0) {
            double value = stack.pop();
            double result = Math.sqrt(value);

            stack.push(result);

            operationLogs.push(new OperationLog().withPushed(result).withPopped(value));
        } else
            throw new InsufficientParametersException();
    }
}
