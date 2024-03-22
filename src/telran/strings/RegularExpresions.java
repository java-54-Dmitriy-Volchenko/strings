package telran.strings;

public class RegularExpresions {
	public static String javaVariable() {
		String regex = "([A-Za-z$][\\w$]*|_[\\w$]+)";
		return regex;
	}
	public static String zero_300() {
		String regex ="[1-9]\\d?|[1-2]\\d\\d|300|0";
		
		return regex;
	}
	public static String ipOctet() {
		
		String regex ="([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";//дополнительные скобки нужны чтобы использовать этот окттет потом в IP
		return regex;
	}
	
	public static String mobileIsraelPhone() {
		
		String regex ="(\\+972-|0)5(\\d-\\d{7}|\\d-\\d{7})";
		
		return regex;
	}
	
	public static String ipV4Address() {
		String ipOctetExpr = ipOctet();
		return String.format("%1$s(\\.%1$s){3}", ipOctetExpr);
	}
	public static String simpleArithmeticExpression() {
		//operations only binary +,-,*,/
		//operands only integer numbers
		//no brackets 
		String operand = integerNumberExp();
		return commonArithmeticExpression(operand);
	}
	private static String commonArithmeticExpression(String operand) {
		String operation = operationExp();
		return String.format("%1$s(%2$s%1$s)*", operand, operation);
	}
	private static String operationExp() {
		
		return "[-+*/]";
	}
	private static String integerNumberExp() {
		
		return "(\\s*\\d+\\s*)";
	}
	public static String arithmeticExpression() {
		//operand - any number or Java variable name
		//operation - the same as for simpleArithmeticExpression
		//brackets '(' ')' are allowed
		String operand = arithmeticOperandExpression();
		return commonArithmeticExpression(operand);
	}
	private static String arithmeticOperandExpression() {
		String variableExp = javaVariable();
		String numberExp = anyNumber();
		return String.format("[\\s(]*(%s|%s)[\\s)]*", variableExp, numberExp);
	}
	private static String anyNumber() {
		
		return "(\\d*\\.?\\d+|d+\\.)";
	}
	}