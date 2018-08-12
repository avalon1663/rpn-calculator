package org.coding.exercise.service;

import org.coding.exercise.common.InsufficientParametersException;
import org.coding.exercise.common.OperationLog;
import org.coding.exercise.common.UnsupportedStackOperationException;
import org.coding.exercise.operation.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Stack;

import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class ReversePolishNotionServiceCalculationTest {

    @Test
    public void parseCommandAsOperation() throws UnsupportedStackOperationException, InsufficientParametersException {
        String command = "command";
        Stack<Double> stack = new Stack<>();
        Stack<OperationLog> operationLogs = new Stack<>();
        StackOperation stackOperation = mock(StackOperation.class);

        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService(stack, operationLogs);
        ReversePolishNotionService spy = spy(reversePolishNotionService);

        doReturn(stackOperation).when(spy).resolveAsOperation(command);

        spy.parseCommand(command);
    }

    @Test
    public void parseCommandAsInput() throws UnsupportedStackOperationException, InsufficientParametersException {
        String command = "command";
        Stack<Double> stack = new Stack<>();
        Stack<OperationLog> operationLogs = new Stack<>();

        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService(stack, operationLogs);
        ReversePolishNotionService spy = spy(reversePolishNotionService);

        doThrow(new UnsupportedStackOperationException()).when(spy).resolveAsOperation(command);
        doNothing().when(spy).resolveAsInput(command, stack, operationLogs);

        spy.parseCommand(command);
    }

    @Test
    public void resolveAsStackAddition() throws UnsupportedStackOperationException {
        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService();
        StackOperation stackOperation =
                reversePolishNotionService.resolveAsOperation("+");
        Assert.assertTrue(stackOperation instanceof StackAddition);
    }

    @Test
    public void resolveAsStackClear() throws UnsupportedStackOperationException {
        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService();
        StackOperation stackOperation =
                reversePolishNotionService.resolveAsOperation("clear");
        Assert.assertTrue(stackOperation instanceof StackClear);
    }

    @Test
    public void resolveAsStackDivision() throws UnsupportedStackOperationException {
        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService();
        StackOperation stackOperation =
                reversePolishNotionService.resolveAsOperation("/");
        Assert.assertTrue(stackOperation instanceof StackDivision);
    }

    @Test
    public void resolveAsStackMultiplication() throws UnsupportedStackOperationException {
        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService();
        StackOperation stackOperation =
                reversePolishNotionService.resolveAsOperation("*");
        Assert.assertTrue(stackOperation instanceof StackMultiplication);
    }

    @Test
    public void resolveAsStackSquareRoot() throws UnsupportedStackOperationException {
        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService();
        StackOperation stackOperation =
                reversePolishNotionService.resolveAsOperation("sqrt");
        Assert.assertTrue(stackOperation instanceof StackSquareRoot);
    }

    @Test
    public void resolveAsStackSubtraction() throws UnsupportedStackOperationException {
        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService();
        StackOperation stackOperation =
                reversePolishNotionService.resolveAsOperation("-");
        Assert.assertTrue(stackOperation instanceof StackSubtraction);
    }

    @Test
    public void resolveAsStackUndo() throws UnsupportedStackOperationException {
        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService();
        StackOperation stackOperation =
                reversePolishNotionService.resolveAsOperation("undo");
        Assert.assertTrue(stackOperation instanceof StackUndo);
    }

    @Test(expected = UnsupportedStackOperationException.class)
    public void resolveAsUnsupportedStackOperationException() throws UnsupportedStackOperationException {
        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService();
        reversePolishNotionService.resolveAsOperation("10");
    }

    @Test
    public void resolveStackOperation() throws InsufficientParametersException {
        StackOperation
                stackOperation = mock(StackOperation.class);
        Stack<Double> stack = new Stack<>();
        Stack<OperationLog> operationLogs = new Stack<>();

        doNothing().when(stackOperation).run(stack, operationLogs);

        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService(stack, operationLogs);
        reversePolishNotionService.resolveStackOperation(stackOperation, stack, operationLogs);
    }

    @Test(expected = InsufficientParametersException.class)
    public void resolveStackOperationException() throws InsufficientParametersException {
        StackOperation
                stackOperation = mock(StackOperation.class);
        Stack<Double> stack = new Stack<>();
        Stack<OperationLog> operationLogs = new Stack<>();

        doThrow(new InsufficientParametersException()).when(stackOperation).run(stack, operationLogs);

        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService(stack, operationLogs);
        reversePolishNotionService.resolveStackOperation(stackOperation, stack, operationLogs);
    }

    @Test
    public void resolveAsInput() {
        String command = "10";
        Stack<Double> stack = new Stack<>();
        Stack<OperationLog> operationLogs = new Stack<>();

        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService(stack, operationLogs);
        reversePolishNotionService.resolveAsInput(command, stack, operationLogs);

        Assert.assertEquals(new Double(10D), stack.peek());
        Assert.assertEquals(new OperationLog().withPushed(10D), operationLogs.peek());
    }

    @Test(expected = NumberFormatException.class)
    public void resolveAsInputException() {
        String command = "#";
        Stack<Double> stack = new Stack<>();
        Stack<OperationLog> operationLogs = new Stack<>();

        ReversePolishNotionService
                reversePolishNotionService = new ReversePolishNotionService(stack, operationLogs);
        reversePolishNotionService.resolveAsInput(command, stack, operationLogs);
    }
}