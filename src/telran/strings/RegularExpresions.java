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
		//TODO
		//string contains 1 - 3 symbols presents number from 0-255 ; leading zero are allowed
		String regex ="[0-1]?\\d?\\d|[2][0-4]\\d|[2][5][0-5]";
		return regex;
	}
	
	public static String mobileIsraelPhon() {
		//TODO
		//string contains possible Israel mobile phone number
		//+972-<prefix two digits beginning from 5>-<7 digits of number>
		//start		return null;
		return null;
	}
}
