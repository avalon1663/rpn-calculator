package org.coding.exercise;

import org.coding.exercise.common.InsufficientParametersException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;

@RunWith(JUnit4.class)
public class ReversePolishNotionCalculatorTest {

    @Test
    public void case1() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input = "5 2";
        Stack<Double> stack =
                this.calculate(calculator, input);
        Assert.assertArrayEquals(new Object[]{5D, 2D}, stack.toArray());
    }

    @Test
    public void case2() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "2 sqrt";
        Stack<Double> stack1 =
                this.calculate(calculator, input1);
        System.out.println(stack1);

        String input2 = "clear 9 sqrt";
        Stack<Double> stack2 =
                this.calculate(calculator, input2);
        Assert.assertArrayEquals(new Object[]{3D}, stack2.toArray());
    }

    @Test
    public void case3() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "5 2 -";
        Stack<Double> stack1 =
                this.calculate(calculator, input1);
        Assert.assertArrayEquals(new Object[]{3D}, stack1.toArray());

        String input2 = "3 -";
        Stack<Double> stack2 =
                this.calculate(calculator, input2);
        Assert.assertArrayEquals(new Object[]{0D}, stack2.toArray());

        String input3 = "clear";
        Stack<Double> stack3 =
                this.calculate(calculator, input3);
        Assert.assertTrue(stack3.isEmpty());
    }

    @Test
    public void case4() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "5 4 3 2";
        Stack<Double> stack1 =
                this.calculate(calculator, input1);
        Assert.assertArrayEquals(new Object[]{5D, 4D, 3D, 2D}, stack1.toArray());

        String input2 = "undo undo *";
        Stack<Double> stack2 =
                this.calculate(calculator, input2);
        Assert.assertArrayEquals(new Object[]{20D}, stack2.toArray());

        String input3 = "5 *";
        Stack<Double> stack3 =
                this.calculate(calculator, input3);
        Assert.assertArrayEquals(new Object[]{100D}, stack3.toArray());

        String input4 = "undo";
        Stack<Double> stack4 =
                this.calculate(calculator, input4);
        Assert.assertArrayEquals(new Object[]{20D, 5D}, stack4.toArray());

        String input5 = "undo undo";
        Stack<Double> stack5 =
                this.calculate(calculator, input5);
        Assert.assertArrayEquals(new Object[]{5D, 4D}, stack5.toArray());

        String input6 = "undo undo";
        Stack<Double> stack6 =
                this.calculate(calculator, input6);
        Assert.assertTrue(stack6.isEmpty());
    }

    @Test
    public void case5() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "7 12 2 /";
        Stack<Double> stack1 =
                this.calculate(calculator, input1);
        Assert.assertArrayEquals(new Object[]{7D, 6D}, stack1.toArray());

        String input2 = "*";
        Stack<Double> stack2 =
                this.calculate(calculator, input2);
        Assert.assertArrayEquals(new Object[]{42D}, stack2.toArray());

        String input3 = "4 /";
        Stack<Double> stack3 =
                this.calculate(calculator, input3);
        Assert.assertArrayEquals(new Object[]{10.5D}, stack3.toArray());
    }

    @Test
    public void case6() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "1 2 3 4 5";
        Stack<Double> stack1 =
                this.calculate(calculator, input1);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 4D, 5D}, stack1.toArray());

        String input2 = "*";
        Stack<Double> stack2 =
                this.calculate(calculator, input2);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 20D}, stack2.toArray());

        String input3 = "clear 3 4 -";
        Stack<Double> stack3 =
                this.calculate(calculator, input3);
        Assert.assertArrayEquals(new Object[]{-1D}, stack3.toArray());
    }

    @Test
    public void case7() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "1 2 3 4 5";
        Stack<Double> stack1 =
                this.calculate(calculator, input1);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 4D, 5D}, stack1.toArray());

        String input2 = "* * * *";
        Stack<Double> stack2 =
                this.calculate(calculator, input2);
        Assert.assertArrayEquals(new Object[]{120D}, stack2.toArray());
    }

    @Test
    public void case8() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "1 2 3 * 5 + * * 6 5";
        Stack<Double> stack1 =
                this.calculate(calculator, input1);
        Assert.assertArrayEquals(new Object[]{11D}, stack1.toArray());
    }

    private Stack<Double> calculate(ReversePolishNotionCalculator calculator, String input) {
        Scanner scanner =
                new Scanner(new ByteArrayInputStream(input.getBytes()));
        int position = 0;

        while (scanner.hasNext()) {
            String command =
                    scanner.next();
            position += 1;
            try {
                calculator.parseCommand(command);
            } catch (InsufficientParametersException e) {
                System.err.println("operator " + command
                        + " (position: " + position + "): insufficient parameters");
                break;
            }
            position += 1;
        }
        return calculator.getStack();
    }
}