package org.coding.exercise.common;

import java.util.Objects;
import java.util.Stack;

public class OperationLog {

    private Stack<Double> pushed = new Stack<>();
    private Stack<Double> popped = new Stack<>();

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationLog that = (OperationLog) o;
        return Objects.equals(pushed, that.pushed) &&
                Objects.equals(popped, that.popped);
    }

    public int hashCode() {
        return Objects.hash(pushed, popped);
    }

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
