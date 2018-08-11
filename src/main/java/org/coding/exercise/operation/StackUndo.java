package org.coding.exercise.operation;

import org.coding.exercise.common.OperationLog;

import java.util.Stack;

public class StackUndo implements StackOperation {

    public void run(Stack<Double> stack, Stack<OperationLog> operationLogs) {
        double popped = stack.pop();

        OperationLog undoLog =
                new OperationLog().withPopped(popped);
        OperationLog redoLog = operationLogs.pop();

        while (!redoLog.getPopped().isEmpty()) {
            double pop = redoLog.getPopped().pop();
            stack.push(pop);
            undoLog.withPushed(pop);
        }
    }
}
