package sampleCode.CodeWithTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyClassTest {
    @Test
    public void testToString() {
        MyClass me = new MyClass("Me", 100);

        String actual = me.toString();

        assertEquals("My name is Me and I'm 100 years old.", actual);
    }
}
