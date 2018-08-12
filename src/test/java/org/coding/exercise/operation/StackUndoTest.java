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
public class StackUndoTest {

    @Test
    @SuppressWarnings("unchecked")
    public void run() throws InsufficientParametersException {
        Stack<Double> stack = new Stack<>();
        stack.push(10D);
        stack.push(20D);
        stack.push(30D);

        Stack<OperationLog> operationLogs = new Stack<>();
        operationLogs.push(new OperationLog().withPushed(10D));
        operationLogs.push(new OperationLog().withPushed(20D));
        operationLogs.push(new OperationLog().withPushed(30D));

        StackOperation
                op1 = new StackUndo();
        op1.run(stack, operationLogs);

        Assert.assertEquals(2, stack.size());
        Assert.assertEquals(new Double(20D), stack.peek());

        double pop = stack.pop();
        operationLogs.push(new OperationLog().withOrderPopped(pop));

        StackOperation
                op2 = new StackUndo();
        op2.run(stack, operationLogs);

        Assert.assertEquals(2, stack.size());
        Assert.assertEquals(new Double(20D), stack.peek());
    }

    @Test(expected = InsufficientParametersException.class)
    @SuppressWarnings("unchecked")
    public void withInsufficientParametersException() throws InsufficientParametersException {
        Stack<Double> stack = new Stack<>();
        Stack<OperationLog> operationLogs = mock(Stack.class);

        StackOperation
                stackOperation = new StackUndo();
        stackOperation.run(stack, operationLogs);
    }
}