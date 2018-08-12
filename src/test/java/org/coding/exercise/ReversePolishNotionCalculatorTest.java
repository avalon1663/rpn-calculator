package org.coding.exercise;

import org.coding.exercise.common.UnsupportedStackOperationException;
import org.coding.exercise.operation.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReversePolishNotionCalculatorTest {

    @Test
    public void resolveAsStackAddition() throws UnsupportedStackOperationException {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        StackOperation stackOperation =
                calculator.resolveAsOperation("+");
        Assert.assertTrue(stackOperation instanceof StackAddition);
    }

    @Test
    public void resolveAsStackClear() throws UnsupportedStackOperationException {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        StackOperation stackOperation =
                calculator.resolveAsOperation("clear");
        Assert.assertTrue(stackOperation instanceof StackClear);
    }

    @Test
    public void resolveAsStackDivision() throws UnsupportedStackOperationException {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        StackOperation stackOperation =
                calculator.resolveAsOperation("/");
        Assert.assertTrue(stackOperation instanceof StackDivision);
    }

    @Test
    public void resolveAsStackMultiplication() throws UnsupportedStackOperationException {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        StackOperation stackOperation =
                calculator.resolveAsOperation("*");
        Assert.assertTrue(stackOperation instanceof StackMultiplication);
    }

    @Test
    public void resolveAsStackSquareRoot() throws UnsupportedStackOperationException {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        StackOperation stackOperation =
                calculator.resolveAsOperation("sqrt");
        Assert.assertTrue(stackOperation instanceof StackSquareRoot);
    }

    @Test
    public void resolveAsStackSubtraction() throws UnsupportedStackOperationException {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        StackOperation stackOperation =
                calculator.resolveAsOperation("-");
        Assert.assertTrue(stackOperation instanceof StackSubtraction);
    }

    @Test
    public void resolveAsStackUndo() throws UnsupportedStackOperationException {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        StackOperation stackOperation =
                calculator.resolveAsOperation("undo");
        Assert.assertTrue(stackOperation instanceof StackUndo);
    }

    @Test(expected = UnsupportedStackOperationException.class)
    public void resolveAsUnsupportedStackOperationException() throws UnsupportedStackOperationException {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        calculator.resolveAsOperation("10");
    }
}