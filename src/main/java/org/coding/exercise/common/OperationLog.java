package org.coding.exercise.common;

import java.util.Stack;

public class OperationLog {

    private Stack<Double> pushed = new Stack<>();
    private Stack<Double> popped = new Stack<>();

    public Stack<Double> getPushed() {
        return pushed;
    }

    public Stack<Double> getPopped() {
        return popped;
    }

    public OperationLog withPushed(double number) {
        this.pushed.push(number);
        return this;
    }

    public OperationLog withOrderPopped(double... numbers) {
        for (double number : numbers) {
            this.popped.push(number);
        }
        return this;
    }
}
