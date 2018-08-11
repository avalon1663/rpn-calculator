package org.coding.exercise.operation;

import org.coding.exercise.common.OperationLog;

import java.util.Stack;

public class StackClear implements StackOperation {

    public void run(Stack<Double> stack, Stack<OperationLog> operationLogs) {
        stack.clear();
        operationLogs.clear();
    }
}
