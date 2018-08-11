package org.coding.exercise.operation;

import org.coding.exercise.common.StackOperationLog;

import java.util.Stack;

public class StackClear implements StackOperation {

    public void run(Stack<Double> stack, Stack<StackOperationLog> stackOperationLogs) {
        stack.clear();
        stackOperationLogs.clear();
    }
}
