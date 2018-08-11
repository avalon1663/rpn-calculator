package org.coding.exercise;

import org.coding.exercise.common.NotAnOperatorException;
import org.coding.exercise.common.OperationLog;
import org.coding.exercise.common.Operator;
import org.coding.exercise.operation.StackOperation;

import java.util.Stack;

public class ReversePolishNotionCalculator {

    private Stack<Double> stack = new Stack<>();
    private Stack<OperationLog> operationLogs = new Stack<>();

    public void parseCommand(String command) {
        try {
            Operator operator =
                    Operator.fromText(command);
            this.resolveOperator(operator.stackOperation(), this.stack, this.operationLogs);
        } catch (NotAnOperatorException e) {
            double number =
                    Double.parseDouble(command);
            this.resolveInput(number, this.stack, this.operationLogs);
        }
    }

    protected void resolveOperator(StackOperation stackOperation, Stack<Double> stack, Stack<OperationLog> operationLogs) {
        stackOperation.run(stack, operationLogs);
    }

    protected void resolveInput(double number, Stack<Double> stack, Stack<OperationLog> operationLogs) {
        stack.push(number);
        operationLogs.push(new OperationLog().withPushed(number));
    }

    public Stack<Double> getStack() {
        return this.stack;
    }
}
