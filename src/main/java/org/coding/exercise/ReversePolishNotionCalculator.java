package org.coding.exercise;

import org.coding.exercise.common.NotAnOperatorException;
import org.coding.exercise.common.Operator;
import org.coding.exercise.common.StackOperationLog;

import java.util.Stack;

public class ReversePolishNotionCalculator {

    private Stack<Double> stack = new Stack<>();
    private Stack<StackOperationLog> stackOperationLogs = new Stack<>();

    public void parseCommand(String command) {
        try {
            Operator operator =
                    Operator.fromText(command);
            this.resolveOperator(operator);
        } catch (NotAnOperatorException e) {
            double number =
                    Double.parseDouble(command);
            this.resolveInput(number);
        }
    }

    protected void resolveOperator(Operator operator) {
        operator.stackOperationSpec().run(this.stack, this.stackOperationLogs);
    }

    protected void resolveInput(double number) {
        this.stack.push(number);
        this.stackOperationLogs.push(new StackOperationLog().withPushed(number));
    }

    public Stack<Double> getStack() {
        return this.stack;
    }
}
