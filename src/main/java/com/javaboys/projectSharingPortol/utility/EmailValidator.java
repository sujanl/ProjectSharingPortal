package com.javaboys.projectSharingPortol.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	public static boolean validateEmail(String email) {
		/*boolean b = email.contains("@") && email.contains(".");
		if(b) {
			return true;
		}else {
			return false;
		}*/
		
		Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
	    Matcher m = p.matcher(email);
	    if(m.find()) {
			return true;
		}else {
			return false;
		}
	}
}
