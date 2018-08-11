package org.coding.exercise.operation;

import org.coding.exercise.common.InsufficientParametersException;
import org.coding.exercise.common.OperationLog;

import java.util.Stack;

public class StackDivision implements StackOperation {

    public void run(Stack<Double> stack, Stack<OperationLog> operationLogs) throws InsufficientParametersException {
        if (stack.size() > 1) {
            double right = stack.pop();
            double left = stack.pop();
            double result = left / right;

            stack.push(result);

            operationLogs.push(new OperationLog().withPushed(result).withOrderPopped(right, left));
        } else
            throw new InsufficientParametersException();
    }
}
