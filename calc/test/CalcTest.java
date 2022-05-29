package calc.test;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import calc.main.*;

public class CalcTest {
    @Test
    public void testCalcZeroOnBlankInput()
    {
        try{
            assertEquals(0, Calc.add(""));
        }
        catch(Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void testCalcSingleNumberInput()
    {
        try{
            assertEquals(2, Calc.add("2"));
        }
        catch(Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
        
    }

    @Test
    public void testCalcNumberCommaDelimInput()
    {
        try{
            assertEquals(3, Calc.add("1,2"));
        }
        catch(Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
        
    }

    @Test
    public void testCalcNumberNewLineDelimInput()
    {
        try{
            assertEquals(6, Calc.add("1,2\n3"));
        }
        catch(Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
        
    }

    @Test
    public void testCalcWithUserDefinedDelimInput()
    {
        try{
            assertEquals(4, Calc.add("//;\n1;3"));
        }
        catch(Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
        
    }

    @Test
    public void testCalcNagativeInput()
    {
        try{
            assertEquals(4, Calc.add("-1,-2,3"));
            Assert.fail("Exception should have been thrown for negative number");
        }
        catch(InvalidInputException ex)
        {
            assertEquals("Nagatives not allowed : -1,-2", ex.getMessage());
        }
        catch(Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
        
    }

}
