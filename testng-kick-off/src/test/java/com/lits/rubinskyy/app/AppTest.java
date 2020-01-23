package com.lits.rubinskyy.app;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @BeforeClass
    public void beforeClass(){
        System.out.println("***Tests Class AppTest started");
    }

    @BeforeClass
    public void beforeMethod(){
        System.out.println("***Before each Tests Method");
    }

     /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp()
    {
        assertTrue( true );
    }

    @Test
    public void firstTest()
    {
        assertEquals( 10, 10, "10 is not equal 4" );
    }
}
