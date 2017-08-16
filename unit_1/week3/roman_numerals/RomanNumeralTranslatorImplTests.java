package com.skilldistillery.translator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RomanNumeralTranslatorImplTests {

    private RomanNumeralTranslatorImpl tr;
    @Before
    public void setUp() throws Exception {
        tr = new RomanNumeralTranslatorImpl();
    }

    @After
    public void tearDown() throws Exception {
        tr = null;
    }

    @Test
    public void test_non_integer_returns_original_string() {
        assertEquals("Frog", translator.translateWord("Frog"));
        assertEquals("3.1415", translator.translateWord("3.1415"));
    }

    @Test
    public void test_first_ten_numerals_print_correctly() {
        assertEquals("I", tr.translate("1"));
        assertEquals("II", tr.translate("2"));
        assertEquals("III", tr.translate("3"));
        assertEquals("IV", tr.translate("4"));
        assertEquals("V", tr.translate("5"));
        assertEquals("VI", tr.translate("6"));
        assertEquals("VII", tr.translate("7"));
        assertEquals("VIII", tr.translate("8"));
        assertEquals("IX", tr.translate("9"));
        assertEquals("X", tr.translate("10"));
    }
    @Test
    public void test_eleven_to_twenty() {
        assertEquals("XI", tr.translate("11"));
        assertEquals("XII", tr.translate("12"));
        assertEquals("XIII", tr.translate("13"));
        assertEquals("XIV", tr.translate("14"));
        assertEquals("XV", tr.translate("15"));
        assertEquals("XVI", tr.translate("16"));
        assertEquals("XVII", tr.translate("17"));
        assertEquals("XVIII", tr.translate("18"));
        assertEquals("XIX", tr.translate("19"));
        assertEquals("XX", tr.translate("20"));
    }
    
    @Test
    public void test_40_to_50(){
        assertEquals("XL", tr.translate("40"));
        assertEquals("XLI", tr.translate("41"));
        assertEquals("XLII", tr.translate("42"));
        assertEquals("XLIII", tr.translate("43"));
        assertEquals("XLIV", tr.translate("44"));
        assertEquals("XLV", tr.translate("45"));
        assertEquals("XLVI", tr.translate("46"));
        assertEquals("XLVII", tr.translate("47"));
        assertEquals("XLVIII", tr.translate("48"));
        assertEquals("XLIX", tr.translate("49"));
        assertEquals("L", tr.translate("50"));
    }

}
