package _99Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator c = new Calculator();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        System.out.println(c.add(2,8));
    }

    @Test
    public void subtract() {
        System.out.println(c.subtract(8,5));
    }
}