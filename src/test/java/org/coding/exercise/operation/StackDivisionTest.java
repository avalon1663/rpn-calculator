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
public class StackDivisionTest {

    @Test
    public void run() throws InsufficientParametersException {
        Stack<Double> stack = new Stack<>();
        stack.push(1D);
        stack.push(2D);
        Stack<OperationLog> operationLogs = new Stack<>();

        StackOperation
                stackOperation = new StackDivision();
        stackOperation.run(stack, operationLogs);

        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(new Double(0.5D), stack.peek());

        Assert.assertEquals(1, operationLogs.size());

        OperationLog operationLog =
                new OperationLog().withPushed(0.5D).withOrderPopped(2D, 1D);
        Assert.assertArrayEquals(operationLog.getPushed().toArray(), operationLogs.peek().getPushed().toArray());
        Assert.assertArrayEquals(operationLog.getPopped().toArray(), operationLogs.peek().getPopped().toArray());
    }

    @Test(expected = InsufficientParametersException.class)
    @SuppressWarnings("unchecked")
    public void withInsufficientParametersException() throws InsufficientParametersException {
        Stack<Double> stack = new Stack<>();
        stack.push(1D);
        Stack<OperationLog> operationLogs = mock(Stack.class);

        StackOperation
                stackOperation = new StackDivision();
        stackOperation.run(stack, operationLogs);
    }
}