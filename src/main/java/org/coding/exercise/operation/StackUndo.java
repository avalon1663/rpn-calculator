package org.coding.exercise.operation;

import org.coding.exercise.common.InsufficientParametersException;
import org.coding.exercise.common.OperationLog;

import java.util.Stack;

public class StackUndo implements StackOperation {

    public void run(Stack<Double> stack, Stack<OperationLog> operationLogs) throws InsufficientParametersException {
        if (stack.size() > 0) {
            OperationLog undoLog =
                    operationLogs.pop();
            while (!undoLog.getPushed().isEmpty()) {
                undoLog.getPushed().pop();
                stack.pop();
            }
            while (!undoLog.getPopped().isEmpty()) {
                double pop = undoLog.getPopped().pop();
                stack.push(pop);
            }
        } else
            throw new InsufficientParametersException();
    }
}
