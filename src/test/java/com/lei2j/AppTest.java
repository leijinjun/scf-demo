package com.lei2j;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testHandle() throws IOException {
        System.setProperty(Constants.COOKIE_BBS_SID,"111");
        System.setProperty(Constants.COOKIE_BBS_TOKEN,"222");
        new App().mainHandler("");
    }
}
