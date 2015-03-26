package com.gmail.at.ivanehreshi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
	
	public static boolean checkValidity(String number){
		
		String preparedNumber = number.trim().replaceAll(" {2,}", " ");
		
		Pattern pattern = 
				Pattern.compile("((\\+ ?)?\\d[ \\-])?" + 
		"(((\\d{3,4})|\\(\\d{3,4}\\))[ \\-])?\\d{2,3}[ \\-]\\d" 
						+ "{2,3}[ \\-]\\d{2,3}");
		Matcher matcher = pattern.matcher(preparedNumber);
		return matcher.matches();
	}

	public static void main(String[] args) {
		System.out.println(checkValidity("+ 8 111 11 54"));
	}
	
}
