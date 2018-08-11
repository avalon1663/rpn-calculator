package org.coding.exercise;

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
        System.out.println(stack3);

        Assert.assertArrayEquals(new Object[]{20D, 5D}, stack4.toArray());
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

    private Stack<Double> calculate(ReversePolishNotionCalculator calculator, String input) {
        Scanner scanner =
                new Scanner(new ByteArrayInputStream(input.getBytes()));
        while (scanner.hasNext()) {
            String next = scanner.next();
            calculator.parseCommand(next);
        }
        return calculator.getStack();
    }
}