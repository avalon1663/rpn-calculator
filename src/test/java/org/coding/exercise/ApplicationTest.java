package org.coding.exercise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RunWith(JUnit4.class)
public class ApplicationTest {

    @Test
    public void case1() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input = "5 2";
        calculator.parseCommandSequence(input);
        Assert.assertArrayEquals(new Object[]{5D, 2D}, calculator.getStack().toArray());
    }

    @Test
    public void case2() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "2 sqrt";
        calculator.parseCommandSequence(input1);
        Assert.assertArrayEquals(new Object[]{String.valueOf(new BigDecimal(Math.sqrt(2D)).setScale(10, RoundingMode.HALF_UP).doubleValue())}, calculator.getStackFormatted().toArray());

        String input2 = "clear 9 sqrt";
        calculator.parseCommandSequence(input2);
        Assert.assertArrayEquals(new Object[]{3D}, calculator.getStack().toArray());
    }

    @Test
    public void case3() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "5 2 -";
        calculator.parseCommandSequence(input1);
        Assert.assertArrayEquals(new Object[]{3D}, calculator.getStack().toArray());

        String input2 = "3 -";
        calculator.parseCommandSequence(input2);
        Assert.assertArrayEquals(new Object[]{0D}, calculator.getStack().toArray());

        String input3 = "clear";
        calculator.parseCommandSequence(input3);
        Assert.assertTrue(calculator.getStack().isEmpty());
    }

    @Test
    public void case4() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "5 4 3 2";
        calculator.parseCommandSequence(input1);
        Assert.assertArrayEquals(new Object[]{5D, 4D, 3D, 2D}, calculator.getStack().toArray());

        String input2 = "undo undo *";
        calculator.parseCommandSequence(input2);
        Assert.assertArrayEquals(new Object[]{20D}, calculator.getStack().toArray());

        String input3 = "5 *";
        calculator.parseCommandSequence(input3);
        Assert.assertArrayEquals(new Object[]{100D}, calculator.getStack().toArray());

        String input4 = "undo";
        calculator.parseCommandSequence(input4);
        Assert.assertArrayEquals(new Object[]{20D, 5D}, calculator.getStack().toArray());

        String input5 = "undo undo";
        calculator.parseCommandSequence(input5);
        Assert.assertArrayEquals(new Object[]{5D, 4D}, calculator.getStack().toArray());

        String input6 = "undo undo";
        calculator.parseCommandSequence(input6);
        Assert.assertTrue(calculator.getStack().isEmpty());
    }

    @Test
    public void case5() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "7 12 2 /";
        calculator.parseCommandSequence(input1);
        Assert.assertArrayEquals(new Object[]{7D, 6D}, calculator.getStack().toArray());

        String input2 = "*";
        calculator.parseCommandSequence(input2);
        Assert.assertArrayEquals(new Object[]{42D}, calculator.getStack().toArray());

        String input3 = "4 /";
        calculator.parseCommandSequence(input3);
        Assert.assertArrayEquals(new Object[]{10.5D}, calculator.getStack().toArray());
    }

    @Test
    public void case6() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "1 2 3 4 5";
        calculator.parseCommandSequence(input1);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 4D, 5D}, calculator.getStack().toArray());

        String input2 = "*";
        calculator.parseCommandSequence(input2);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 20D}, calculator.getStack().toArray());

        String input3 = "clear 3 4 -";
        calculator.parseCommandSequence(input3);
        Assert.assertArrayEquals(new Object[]{-1D}, calculator.getStack().toArray());
    }

    @Test
    public void case7() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "1 2 3 4 5";
        calculator.parseCommandSequence(input1);
        Assert.assertArrayEquals(new Object[]{1D, 2D, 3D, 4D, 5D}, calculator.getStack().toArray());

        String input2 = "* * * *";
        calculator.parseCommandSequence(input2);
        Assert.assertArrayEquals(new Object[]{120D}, calculator.getStack().toArray());
    }

    @Test
    public void case8() {
        ReversePolishNotionCalculator
                calculator = new ReversePolishNotionCalculator();
        String input1 = "1 2 3 * 5 + * * 6 5";
        calculator.parseCommandSequence(input1);
        Assert.assertArrayEquals(new Object[]{11D}, calculator.getStack().toArray());
    }
}