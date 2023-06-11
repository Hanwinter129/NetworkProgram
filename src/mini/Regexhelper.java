package mini;

import java.util.regex.Pattern;

// 정규표현식의 싱글톤 클래스 

public class Regexhelper {

	memList m = new memList();
	
	private static Regexhelper current;
	
	public static Regexhelper getInstance() { 
		if( current == null ) {
			current = new Regexhelper();
		}
		return current;
	}

	public static void freeInstance() {
		current = null;
	}

	private Regexhelper(){}

	public boolean isKor( String str ) {   		
		boolean result  = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str);

		return result;	
	}
	
	public boolean isPhone( String str ) {   		
		boolean result = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
	
		return result;						
	}
	


	
	
	
	
	
}
