package org.coding.exercise;

import org.coding.exercise.service.ReversePolishNotionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RunWith(JUnit4.class)
public class CalculatorApplicationTest {

    @Test
    public void case1() {
        CalculatorApplication
                calculator = new CalculatorApplication(new ReversePolishNotionService());
        String input = "5 2";
        calculator.processInput(input);
        Assert.assertArrayEquals(new Object[]{5D, 2D}, calculator.reversePolishNotionService().getStack().toArray());
    }

    @Test
    public void case2() {
        CalculatorApplication
                calculator = new CalculatorApplication(new ReversePolishNotionService());
        String input1 = "2 sqrt";
        calculator.processInput(input1);
        Assert.assertArrayEquals(new Object[]{String.valueOf(new BigDecimal(Math.sqrt(2D)).setScale(10, RoundingMode.HALF_UP).doubleValue())}, calculator.getStackFormatted().toArray());

        String input2 = "clear 9 sqrt";
        calculator.processInput(input2);
        Assert.assertArrayEquals(new Object[]{3D}, calculator.reversePolishNotionService().getStack().toArray());
    }

    @Test
    public void case3() {
        CalculatorApplication
                calculator = new CalculatorApplication(new ReversePolishNotionService());
        String input1 = "5 2 -";
        calculator.processInput(input1);
        Assert.assertArrayEquals(new Object[]{3D}, calculator.reversePolishNotionService().getStack().toArray());

        String input2 = "3 -";
        calculator.processInput(input2);
        Assert.assertArrayEquals(new Object[]{0D}, calculator.reversePolishNotionService().getStack().toArray());

        String input3 = "clear";
        calculator.processInput(input3);
        Assert.assertTrue(calculator.reversePolishNotionService().getStack().isEmpty());
    }

    @Test
    public void case4() {
        CalculatorApplication
                calculator = new CalculatorApplication(new ReversePolishNotionService());
        String input1 = "5 4 3 2";
        calculator.processInput(input1);
        Assert.assertArrayEquals(new Object[]{5D, 4D, 3D, 2D}, calculator.reversePolishNotionService().getStack().toArray());

        String input2 = "undo undo *";
        calculator.processInput(input2);
        Assert.assertArrayEquals(new Object[]{20D}, calculator.reversePolishNotionService().getStack().toArray());

        String input3 = "5 *";
        calculator.processInput(input3);
        Assert.assertArrayEquals(new Object[]{100D}, calculator.reversePolishNotionService().getStack().toArray());

        String input4 = "undo";
        calculator.processInput(input4);
        Assert.assertArrayEquals(new Object[]{20D, 5D}, calculator.reversePolishNotionService().getStack().toArray());

        String input5 = "undo undo";
        calculator.processInput(input5);
        Assert.assertArrayEquals(new Object[]{5D, 4D}, calculator.reversePolishNotionService().getStack().toArray());

        String input6 = "undo undo";
        calculator.processInput(input6);
        Assert.assertTrue(calculator.reversePolishNotionService().getStack().isEmpty());
    }

    @Test
    public void case5() {
        CalculatorApplication
                calculator = new CalculatorApplication(new ReversePolishNotionService());
        String input1 = "7 12 2 /";
        calculator.processInput(input1);
        Assert.assertArrayEquals(new Object[]{7D, 6D}, calculator.reversePolishNotionService().getStack().toArray());

        String input2 = "*";
        calculator.processInput(input2);
        Assert.assertArrayEquals(new Object[]{42D}, calculator.reversePolishNotionService().getStack().toArray());

        String input3 = "4 /";
        calculator.processInput(input3);
        Assert.assertArrayEquals(new Object[]{10.5D}, calculator.reversePolishNotionService().getStack().toArray());
    }

    @Test
    public void case6() {
        CalculatorApplication
                calculator = new CalculatorApplication(new ReversePolishNotionService());
        String input1 = "1 2 3 4 5";
        calculator.processInput(input1);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 4D, 5D}, calculator.reversePolishNotionService().getStack().toArray());

        String input2 = "*";
        calculator.processInput(input2);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 20D}, calculator.reversePolishNotionService().getStack().toArray());

        String input3 = "clear 3 4 -";
        calculator.processInput(input3);
        Assert.assertArrayEquals(new Object[]{-1D}, calculator.reversePolishNotionService().getStack().toArray());
    }

    @Test
    public void case7() {
        CalculatorApplication
                calculator = new CalculatorApplication(new ReversePolishNotionService());
        String input1 = "1 2 3 4 5";
        calculator.processInput(input1);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 4D, 5D}, calculator.reversePolishNotionService().getStack().toArray());

        String input2 = "* * * *";
        calculator.processInput(input2);
        Assert.assertArrayEquals(new Object[]{120D}, calculator.reversePolishNotionService().getStack().toArray());
    }

    @Test
    public void case8() {
        CalculatorApplication
                calculator = new CalculatorApplication(new ReversePolishNotionService());
        String input1 = "1 2 3 * 5 + * * 6 5";
        calculator.processInput(input1);
        Assert.assertArrayEquals(new Object[]{11D}, calculator.reversePolishNotionService().getStack().toArray());
    }
}