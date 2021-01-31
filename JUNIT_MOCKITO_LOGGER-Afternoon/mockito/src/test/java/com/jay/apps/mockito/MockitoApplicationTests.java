package com.jay.apps.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class MockitoApplicationTests {



    @Test
    public void testMultiplyAndTriple() {

        MathAdv mathAdv=Mockito.mock(MathAdv.class);
        Math math= new Math(mathAdv);

        when(mathAdv.mul(5,10)).thenReturn(50);
        int result = math.multiplyAndTriple(5, 10);

        System.out.println("Expected 150 got " + result);
        assertEquals(150, result);

    }

    @Test
    public void testDivideAndDouble() {

        MathAdv mathAdv=Mockito.mock(MathAdv.class);
        Math math= new Math(mathAdv);

        when(mathAdv.div(100,10)).thenReturn(10);
        int result = math.divideAndDouble(100, 10);

        System.out.println("Expected 20 got " + result);
        assertEquals(20, result);

    }



    @Test
    public void testAddAndMultiplyBy10() {

        Math math=Mockito.mock(Math.class);
        MathAdv mathAdv= new MathAdv(math);

        when(math.add(1,4)).thenReturn(5);
        int result = mathAdv.AddNMultiplyBy10(1, 4);

        System.out.println("Expected 50 got " + result);
        assertEquals(50, result);

    }

    @Test
    public void testSubAndDivideBy10() {

        Math math=Mockito.mock(Math.class);
        MathAdv mathAdv= new MathAdv(math);

        when(math.sub(20,10)).thenReturn(10);
        int result = mathAdv.SubNDivBy10(20, 10);

        System.out.println("Expected 1 got " + result);
        assertEquals(1, result);

    }


}
