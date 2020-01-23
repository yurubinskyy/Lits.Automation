package com.lits.rubinskyy.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorAddOperation {
    private Calculator calculator = new Calculator();

    @Test(expectedExceptions = {AssertionError.class} )
    public void testExpected(){
        calculator.reset();

        calculator.setValue(BigDecimal.valueOf(20.0));

        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.ZERO);
    }

    @Test(groups = {"" +
            "" +
            "" +
            "", "simple-operation", "add"},
            description = "This test adds two value")
    public void testAdd(){
        //GIVEN
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.2);

        //WHEN
        calculator.setValue(a);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //WHEN
        calculator.add(b);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.3));
    }

    @Test(description = "This test subtracts two value")
    public void testSubtract(){
        //GIVEN
        BigDecimal a = BigDecimal.valueOf(0.5);
        BigDecimal b = BigDecimal.valueOf(0.1);

        //WHEN
        calculator.setValue(a);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //WHEN
        calculator.subtract(b);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(0.4));
    }

    @Test(description = "This test multiplies two value")
    public void testMultiply(){
        //GIVEN
        BigDecimal a = BigDecimal.valueOf(7);
        BigDecimal b = BigDecimal.valueOf(8);

        //WHEN
        calculator.setValue(a);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //WHEN
        calculator.multiply(b);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(56));
    }

    @Test(description = "This test divides two value")
    public void testDivide(){
        //GIVEN
        BigDecimal a = BigDecimal.valueOf(10);
        BigDecimal b = BigDecimal.valueOf(2);

        //WHEN
        calculator.setValue(a);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), a);

        //WHEN
        calculator.divide(b);

        //THEN
        Assert.assertEquals(calculator.getCurrentAmount(), BigDecimal.valueOf(5));
    }
}
