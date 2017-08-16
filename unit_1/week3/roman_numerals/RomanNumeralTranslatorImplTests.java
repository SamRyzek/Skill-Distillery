package com.skilldistillery.translation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TranslatorRomanNumeralImplTests {

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
        assertEquals("Frog", tr.translateWord("Frog"));
        assertEquals("3.1415", tr.translateWord("3.1415"));
    }

    @Test
    public void test_first_ten_numerals_print_correctly() {
        assertEquals("I", tr.translateWord("1"));
        assertEquals("II", tr.translateWord("2"));
        assertEquals("III", tr.translateWord("3"));
        assertEquals("IV", tr.translateWord("4"));
        assertEquals("V", tr.translateWord("5"));
        assertEquals("VI", tr.translateWord("6"));
        assertEquals("VII", tr.translateWord("7"));
        assertEquals("VIII", tr.translateWord("8"));
        assertEquals("IX", tr.translateWord("9"));
        assertEquals("X", tr.translateWord("10"));
    }
    @Test
    public void test_eleven_to_twenty() {
        assertEquals("XI", tr.translateWord("11"));
        assertEquals("XII", tr.translateWord("12"));
        assertEquals("XIII", tr.translateWord("13"));
        assertEquals("XIV", tr.translateWord("14"));
        assertEquals("XV", tr.translateWord("15"));
        assertEquals("XVI", tr.translateWord("16"));
        assertEquals("XVII", tr.translateWord("17"));
        assertEquals("XVIII", tr.translateWord("18"));
        assertEquals("XIX", tr.translateWord("19"));
        assertEquals("XX", tr.translateWord("20"));
    }
    
    @Test
    public void test_40_to_50(){
        assertEquals("XL", tr.translateWord("40"));
        assertEquals("XLI", tr.translateWord("41"));
        assertEquals("XLII", tr.translateWord("42"));
        assertEquals("XLIII", tr.translateWord("43"));
        assertEquals("XLIV", tr.translateWord("44"));
        assertEquals("XLV", tr.translateWord("45"));
        assertEquals("XLVI", tr.translateWord("46"));
        assertEquals("XLVII", tr.translateWord("47"));
        assertEquals("XLVIII", tr.translateWord("48"));
        assertEquals("XLIX", tr.translateWord("49"));
        assertEquals("L", tr.translateWord("50"));
    }
    @Test
    public void test_1_to_9_simple() {
      assertEquals("I", tr.translateWord("1"));
      assertEquals("II", tr.translateWord("2"));
      assertEquals("III", tr.translateWord("3"));
      assertEquals("V", tr.translateWord("5"));
      assertEquals("VI", tr.translateWord("6"));
      assertEquals("VII", tr.translateWord("7"));
      assertEquals("VIII", tr.translateWord("8"));
    }

    @Test
    public void test_single_digit_subtractive() {
      assertEquals("IV", tr.translateWord("4"));
      assertEquals("IX", tr.translateWord("9"));
    }
    
    @Test
    public void test_10_to_49_simple() {
      assertEquals("X", tr.translateWord("10"));
      assertEquals("XI", tr.translateWord("11"));
      assertEquals("XII", tr.translateWord("12"));
      assertEquals("XIII", tr.translateWord("13"));
      assertEquals("XV", tr.translateWord("15"));
      assertEquals("XVI", tr.translateWord("16"));
      assertEquals("XX", tr.translateWord("20"));
      assertEquals("XXX", tr.translateWord("30"));
      assertEquals("XXXIII", tr.translateWord("33"));
      assertEquals("XXXVIII", tr.translateWord("38"));
    }

    @Test
    public void test_10_to_49_subtractive() {
      assertEquals("XIV", tr.translateWord("14"));
      assertEquals("XIX", tr.translateWord("19"));
      assertEquals("XXIX", tr.translateWord("29"));
      assertEquals("XXIX", tr.translateWord("29"));
      assertEquals("XL", tr.translateWord("40"));
      assertEquals("XLII", tr.translateWord("42"));
      assertEquals("XLV", tr.translateWord("45"));
      assertEquals("XLVIII", tr.translateWord("48"));
    }
    
    @Test
    public void test_10_to_50_multiple_subtractive() {
      assertEquals("XLIV", tr.translateWord("44"));
      assertEquals("XLIX", tr.translateWord("49"));
    }
    
    @Test
    public void test_50_to_99_simple() {
      assertEquals("L", tr.translateWord("50"));
      assertEquals("LII", tr.translateWord("52"));
      assertEquals("LV", tr.translateWord("55"));
      assertEquals("LX", tr.translateWord("60"));
      assertEquals("LXXIII", tr.translateWord("73"));
      assertEquals("LXXX", tr.translateWord("80"));
      assertEquals("LXXXVII", tr.translateWord("87"));
    }

    @Test
    public void test_50_to_99_subtractive() {
      assertEquals("LXXIV", tr.translateWord("74"));
      assertEquals("LXXXIX", tr.translateWord("89"));
      assertEquals("XC", tr.translateWord("90"));
      assertEquals("XCIII", tr.translateWord("93"));
      assertEquals("XCV", tr.translateWord("95"));
      assertEquals("XCVIII", tr.translateWord("98"));
    }

    @Test
    public void test_50_to_99_multiple_subtractive() {
      assertEquals("XCIV", tr.translateWord("94"));
      assertEquals("XCIX", tr.translateWord("99"));
    }
    
    @Test
    public void test_100_to_499() {
      assertEquals("C", tr.translateWord("100"));
      assertEquals("CIII", tr.translateWord("103"));
      assertEquals("CIV", tr.translateWord("104"));
      assertEquals("CXI", tr.translateWord("111"));
      assertEquals("CXL", tr.translateWord("140"));
      assertEquals("CXLIV", tr.translateWord("144"));
      assertEquals("CL", tr.translateWord("150"));
      assertEquals("CLI", tr.translateWord("151"));
      assertEquals("CCCLI", tr.translateWord("351"));
      assertEquals("CD", tr.translateWord("400"));
      assertEquals("CDIX", tr.translateWord("409"));
      assertEquals("CDXL", tr.translateWord("440"));
      assertEquals("CDXLIV", tr.translateWord("444"));
      assertEquals("CDXLIX", tr.translateWord("449"));
      assertEquals("CDXCIX", tr.translateWord("499"));
    }
    
    @Test
    public void test_500_up() {
      assertEquals("D", tr.translateWord("500"));
      assertEquals("DC", tr.translateWord("600"));
    }

}

