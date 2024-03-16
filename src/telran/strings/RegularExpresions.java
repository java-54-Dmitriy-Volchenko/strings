package telran.strings;

public class RegularExpresions {
	public static String javaVariable() {
		String regex = "[A-Za-z$][\\w$]*|_[\\w$]+";
		return regex;
	}
	public static String zero_300() {
		String regex ="[1-9]\\d?|[1-2]\\d\\d|300|0";
		
		return regex;
	}
	public static String ipOctet() {
		
		String regex ="[0-1]?\\d?\\d|[2][0-4]\\d|[2][5][0-5]";//works, but has to be drier
		return regex;
	}
	
	public static String mobileIsraelPhone() {
		
		String regex ="\\+972\\-5\\d-\\d\\d\\d\\d\\d\\d\\d|05\\d\\-\\d\\d\\d\\d\\d\\d\\d";
		//TODO
		//string contains possible Israel mobile phone number
		//+972-<prefix two digits beginning from 5>-<7 digits of number>
		//start		return null;
		return regex;
	}
}
