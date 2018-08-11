package org.coding.exercise.common;

import java.util.Stack;

public class OperationLog {

    private Stack<Double> pushed = new Stack<>();

    private Stack<Double> popped = new Stack<>();

    public Stack<Double> getPushed() {
        return pushed;
    }

    public void setPushed(Stack<Double> pushed) {
        this.pushed = pushed;
    }

    public Stack<Double> getPopped() {
        return popped;
    }

    public void setPopped(Stack<Double> popped) {
        this.popped = popped;
    }

    public OperationLog withPushed(double number) {
        this.pushed.push(number);
        return this;
    }

    public OperationLog withPopped(double... args) {
        for (double arg : args) {
            this.popped.push(arg);
        }
        return this;
    }
}