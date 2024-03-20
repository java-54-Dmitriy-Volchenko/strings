package telran.strings.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import telran.strings.RegularExpresions;

class RegularExpresionsTests {

	@Test
	void javaVariableTrueTest() {
		
		String regex = RegularExpresions.javaVariable();
		assertTrue("abs".matches(regex));
		assertTrue("a".matches(regex));
		assertTrue("$".matches(regex));
		assertTrue("$123".matches(regex));
		assertTrue("$1_23".matches(regex));
		assertTrue("_abs".matches(regex));
		assertTrue("__".matches(regex));
		assertTrue("Abs_".matches(regex));
	}
	@Test
	void javaVariableFalseTest() {
		String regex = RegularExpresions.javaVariable();
		assertFalse("1abs".matches(regex));
		assertFalse("_".matches(regex));
		assertFalse("a-2".matches(regex));
		assertFalse("a 2".matches(regex));
		assertFalse("a?2".matches(regex));
		assertFalse("i*nt".matches(regex));
	}
	@Test
	void zero_300TrueTest() {
		String regex = RegularExpresions.zero_300();
		assertTrue("0".matches(regex));
		assertTrue("1".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("198".matches(regex));
		assertTrue("30".matches(regex));
		assertTrue("299".matches(regex));
		assertTrue("300".matches(regex));
		assertTrue("33".matches(regex));
		
	}
	@Test
	void zero_300FalseTest() {
		String regex = RegularExpresions.zero_300();
		assertFalse("00".matches(regex));
		assertFalse("01".matches(regex));
		assertFalse("19s".matches(regex));
		assertFalse("398".matches(regex));
		assertFalse("30 ".matches(regex));
		assertFalse("2990".matches(regex));
		assertFalse("301".matches(regex));
		assertFalse("-33".matches(regex));
	}
	@Test
	void ipOctetTest() {
		String regex = RegularExpresions.ipOctet();
		assertTrue("0".matches(regex));
		assertTrue("00".matches(regex));
		assertTrue("000".matches(regex));
		assertTrue("10".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("199".matches(regex));
		assertTrue("009".matches(regex));
		assertTrue("255".matches(regex));
		assertTrue("250".matches(regex));
		assertTrue("249".matches(regex));
		assertFalse("-0".matches(regex));
		assertFalse("00 ".matches(regex));
		assertFalse("0000".matches(regex));
		assertFalse("10?".matches(regex));
		assertFalse("1900".matches(regex));
		assertFalse("299".matches(regex));
		assertFalse("00a".matches(regex));
		assertFalse("256".matches(regex));
		assertFalse("260".matches(regex));
		assertFalse("300".matches(regex));
		
	}
	
	@Test
	void mobileIsraelPhoneTest() {
		String regex = RegularExpresions.mobileIsraelPhone();
		
		//checking true
		assertTrue("+972-50-0000000".matches(regex));
		assertTrue("+972-55-7654321".matches(regex));		
		assertTrue("+972-59-9999999".matches(regex));
		assertTrue("050-0000000".matches(regex));
		assertTrue("053-1234567".matches(regex));
		assertTrue("059-9999999".matches(regex));
		
		//checking false prefix 
		assertFalse("972-50-0000000".matches(regex));
		assertFalse("-972-50-0000000".matches(regex));
		assertFalse("+9_2-50-0000000".matches(regex));
		assertFalse("a972-50-0000000".matches(regex));
		assertFalse("!972-50-0000000".matches(regex));
		assertFalse("0972-50-0000000".matches(regex));
		assertFalse("+933-50-0000000".matches(regex));
		assertFalse("@933-50-0000000".matches(regex));
		
		//checking false second prefix 
		assertFalse("+972-65-7654321".matches(regex));		
		assertFalse("+972-43-7654321".matches(regex));
		assertFalse("+972-5a-7654321".matches(regex));
		assertFalse("+972-!3-7654321".matches(regex));
		assertFalse("+972-5@-7654321".matches(regex));
		assertFalse("+972-533-7654321".matches(regex));
		assertFalse("153-1234567".matches(regex));
		assertFalse("1530-1234567".matches(regex));
		assertFalse("+53-1234567".matches(regex));
		assertFalse("063-1234567".matches(regex));
		assertFalse("0_3-1234567".matches(regex));
		assertFalse("05a-1234567".matches(regex));
		assertFalse("03-1234567".matches(regex));
		assertFalse("@3-1234567".matches(regex));
		
		//checking false postfix 
		
		assertFalse("+972-59-99-9999".matches(regex));
		assertFalse("+972-59-99999999".matches(regex));
		assertFalse("+972-59-999999".matches(regex));
		assertFalse("+972-59-999999!".matches(regex));
		assertFalse("+972-59-9999z99".matches(regex));
		assertFalse("+972-59-!000000".matches(regex));
		assertFalse("+972-59-0@00000".matches(regex));
		assertFalse("053-12345678".matches(regex));
		assertFalse("053-123456".matches(regex));
		assertFalse("053-123456!".matches(regex));
		assertFalse("053-1234z67".matches(regex));
		assertFalse("053-!234567".matches(regex));
		assertFalse("055-1@34567".matches(regex));
		
		//checking false hyphens 
		
		assertFalse("+972599999999".matches(regex));
		assertFalse("+9-7-2599999999".matches(regex));
		assertFalse("+97-2599999999".matches(regex));
		assertFalse("+9725-99999999".matches(regex));
		assertFalse("+972599999-999".matches(regex));
		assertFalse("+972_59_9999999".matches(regex));
		assertFalse("+972-59-999-99-99".matches(regex));
		assertFalse("0599999999".matches(regex));
		assertFalse("05-99999999".matches(regex));
		assertFalse("0-5-99999999".matches(regex));
		assertFalse("059-999-99-99".matches(regex));
		
		
	}
	@Test
	@DisplayName("test for IP v4 adress regular expression")
	void ipV4AddressTest() {
		String ipV4Regex = RegularExpresions.ipV4Address();
		assertTrue("1.2.3.4" .matches(ipV4Regex));
		assertFalse("1.2.3" .matches(ipV4Regex));
		assertFalse("1 2.3.4" .matches(ipV4Regex));
		assertFalse("1. 2.3.4" .matches(ipV4Regex));
		assertFalse("1.2.3.4.5" .matches(ipV4Regex));
		assertFalse("1.2.3&4" .matches(ipV4Regex));
		
	}
	@Test
	@DisplayName("test of simple arithmetic expression")
	void simpleArithmeticExpressionsTest() {
		String regex = RegularExpresions.simpleArithmeticExpression();
		
		assertTrue("20".matches(regex));
		assertTrue(" 20 +3 /2 *100".matches(regex));
		assertTrue("10000-1".matches(regex));
		assertTrue("10000-1 ".matches(regex));
		assertFalse("-20".matches(regex));
		assertFalse("20 ** 3".matches(regex));
		assertFalse("20 +3 /2 *100 +".matches(regex));
		assertFalse("20 +3 //2 *100 +1".matches(regex));
		
	}
	@Test
	@DisplayName("test of arithmetic expression with any numbers or variable names and br")
	void arithmeticExpressionTest(){
		String regex = RegularExpresions.arithmeticExpression();
		assertTrue("(20.5 + abc)*2".matches(regex));		
		assertTrue("(20.5 + abc12))*2".matches(regex));
		assertTrue("(20.5 + (abc$ / 3)*(2".matches(regex));
		assertTrue("(__)".matches(regex));
		assertFalse("2 + _".matches(regex));
		assertFalse("2 + a12 * ".matches(regex));
		assertFalse("(2 + )a12 * ".matches(regex));
		
	}
	}
	
	
	
	

