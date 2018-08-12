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
public class StackSquareRootTest {

    @Test
    @SuppressWarnings("unchecked")
    public void run() throws InsufficientParametersException {
        Stack<Double> stack = new Stack<>();
        stack.push(9D);
        Stack<OperationLog> operationLogs = mock(Stack.class);

        StackOperation
                stackOperation = new StackSquareRoot();
        stackOperation.run(stack, operationLogs);

        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(new Double(3D), stack.peek());
    }

    @Test(expected = InsufficientParametersException.class)
    @SuppressWarnings("unchecked")
    public void withInsufficientParametersException() throws InsufficientParametersException {
        Stack<Double> stack = new Stack<>();
        Stack<OperationLog> operationLogs = mock(Stack.class);

        StackOperation
                stackOperation = new StackSquareRoot();
        stackOperation.run(stack, operationLogs);
    }
}