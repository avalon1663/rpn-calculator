package org.coding.exercise.common;

import org.coding.exercise.operation.*;

public enum Operator {

    PLUS(new StackAddition()),
    MINUS(new StackSubtraction()),
    TIMES(new StackMultiplication()),
    OBELUS(new StackDivision()),
    SQRT(new StackSquareRoot()),
    UNDO(new StackUndo()),
    CLEAR(new StackClear());

    private StackOperation stackOperation;

    Operator(StackOperation stackOperation) {
        this.stackOperation = stackOperation;
    }

    public static Operator fromText(String text) throws NotAnOperatorException {
        if ("+".equals(text)) {
            return PLUS;
        } else if ("-".equals(text)) {
            return MINUS;
        } else if ("*".equals(text)) {
            return TIMES;
        } else if ("/".equals(text)) {
            return OBELUS;
        } else if ("sqrt".equalsIgnoreCase(text)) {
            return SQRT;
        } else if ("undo".equalsIgnoreCase(text)) {
            return UNDO;
        } else if ("clear".equalsIgnoreCase(text)) {
            return CLEAR;
        } else
            throw new NotAnOperatorException();
    }

    public StackOperation stackOperation() {
        return this.stackOperation;
    }
}