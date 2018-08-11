package org.coding.exercise.operation;

import org.coding.exercise.common.StackOperationLog;

import java.util.Stack;

public class StackUndo implements StackOperation {

    public void run(Stack<Double> stack, Stack<StackOperationLog> stackOperationLogs) {
        double popped = stack.pop();

        StackOperationLog undoLog =
                new StackOperationLog().withPopped(popped);
        StackOperationLog redoLog = stackOperationLogs.pop();

        while (!redoLog.getPopped().isEmpty()) {
            double pop = redoLog.getPopped().pop();
            stack.push(pop);
            undoLog.withPushed(pop);
        }
    }
}
