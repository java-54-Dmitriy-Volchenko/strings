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
		String operation = operationExp();
		return String.format("%1$s(%2$s%1$s)*", operand, operation);
	}
	
	public static String integerNumberExp() {
		return "(\\s*\\d+\\s*)";//пробелы перед и после в любом количестве, между ними как минимум одна цифра
	}

	public static String operationExp() {
		return "[-+*/]";
	}
	public static String arithmeticExpression() {
		//TODO
	
		//operand - any number or Java variable name
		//operation - the same as for simpleArithmeticExpression
		//brackets '(' ')' are allowed
		String operation = operationExp();
		String operand = numberExpFull();
		
		return String.format("%1$s(%2$s%1$s)*", operand, operation);
	}
	
		public static String numberExpFull() {
		
			return //"(\\s*\\(*((\\d+?(\\.\\d+?)?)|([A-Za-z$][\\w$]*|_[\\w$]+?)|_{2})\\)*\\s*)";
	//              (\\s*\\(* (\\d+ (\\.\\d+) ? |([A-Za-z$][\\w$]*|_[\\w$]+) )      \\)*\\s*)";  
			         "(\\s*\\(*((\\d+(\\.\\d+)?)|([A-Za-z$][\\w$]*|_[\\w$]+))\\)*\\s*)";

		
	}

}
