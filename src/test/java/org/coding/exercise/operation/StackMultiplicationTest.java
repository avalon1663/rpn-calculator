package org.coding.exercise.operation;

import org.coding.exercise.common.InsufficientParametersException;
import org.coding.exercise.common.OperationLog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Stack;

import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class StackMultiplicationTest {

    @Test
    @SuppressWarnings("unchecked")
    public void run() throws InsufficientParametersException {
        Stack<Double> stack = new Stack<>();
        stack.push(1D);
        stack.push(2D);
        Stack<OperationLog> operationLogs = mock(Stack.class);

        StackOperation
                stackOperation = new StackMultiplication();
        stackOperation.run(stack, operationLogs);

        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(new Double(2D), stack.peek());
    }

    @Test(expected = InsufficientParametersException.class)
    @SuppressWarnings("unchecked")
    public void withInsufficientParametersException() throws InsufficientParametersException {
        Stack<Double> stack = new Stack<>();
        stack.push(1D);
        Stack<OperationLog> operationLogs = mock(Stack.class);

        StackOperation
                stackOperation = new StackMultiplication();
        stackOperation.run(stack, operationLogs);
    }
}