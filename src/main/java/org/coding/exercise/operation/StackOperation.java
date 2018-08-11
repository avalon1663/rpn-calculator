package org.coding.exercise.operation;

import org.coding.exercise.common.StackOperationLog;

import java.util.Stack;

public interface StackOperation {

    void run(Stack<Double> stack, Stack<StackOperationLog> stackOperationLogs);
}
