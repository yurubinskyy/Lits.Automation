package com.lits.rubinskyy.calculator;

import com.lits.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CalculatorParametrizedTest{
        private Calculator calculator = new Calculator();

    @Test(dataProvider = "data")
    public void testAddTwoNumbers(BigDecimal a, BigDecimal b, BigDecimal result){
        Calculator calculator = new Calculator();
        //WHEN
        calculator.setValue(a);
        calculator.add(b);

        //THEN
        //Assert.assertEquals(calculator.getCurrentAmount(), result);
        int compareResult = result.compareTo(calculator.getCurrentAmount());
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider(parallel =  true)
    public Object[][] data() {
        return new Object[][]{
                {BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(3.0)},
                {BigDecimal.valueOf(-1.5), BigDecimal.valueOf(1.5), BigDecimal.valueOf(0.0)},
                {BigDecimal.valueOf(2.5), BigDecimal.valueOf(0), BigDecimal.valueOf(2.5)},
                {BigDecimal.valueOf(1000), BigDecimal.valueOf(1.5), BigDecimal.valueOf(1001.5)},
                {BigDecimal.valueOf(-9.142), BigDecimal.valueOf(0.142), BigDecimal.valueOf(-9.0)},
        };
    }

    @Test(dataProvider = "dataForSubtract")
    public void testSubtractTwoNumbers(BigDecimal a, BigDecimal b, BigDecimal result){
        //WHEN
        calculator.setValue(a);
        calculator.subtract(b);

        //THEN
        //Assert.assertEquals(calculator.getCurrentAmount(), result);
        int compareResult = result.compareTo(calculator.getCurrentAmount());
        Assert.assertEquals(compareResult, 0);
    }

    @DataProvider
    public Object[][] dataForSubtract() {
        return new Object[][]{
                {BigDecimal.valueOf(5), BigDecimal.valueOf(3.0), BigDecimal.valueOf(2.0)},
                {BigDecimal.valueOf(-5), BigDecimal.valueOf(2.0), BigDecimal.valueOf(-7.0)},
                {BigDecimal.valueOf(-5), BigDecimal.valueOf(-1), BigDecimal.valueOf(-4)},
        };
    }
}
