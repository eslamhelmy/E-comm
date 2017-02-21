package com.Commerce;
import java.util.regex.Pattern;

public class UserValidate {
		
		private String regex;
		private boolean matches;

		public boolean checkName(String name){
			regex = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
			if( Pattern.compile(regex).matcher(name).matches()){
				matches =true;
			}
			return matches;
		}
		public boolean checkEmail(String email){
			regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if( Pattern.compile(regex).matcher(email).matches()){
				matches =true;
			}
			return matches;
		}
		public boolean checkAddress(String address){
			regex = "^\\d{1,5}\\s\\w.(\\b\\w*\\b\\s){1,2}\\w*";   //as [253 N.Cherry St]
			if( Pattern.compile(regex).matcher(address).matches()){
				matches =true;
			}
			return matches;
		}
		public boolean checkBrithDate(String brithDate){
			regex = "^((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d))$";   
			if( Pattern.compile(regex).matcher(brithDate).matches()){
				matches =true;
			}
			return matches;
		}
		
		

}
