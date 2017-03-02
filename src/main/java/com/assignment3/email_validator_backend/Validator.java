package com.assignment3.email_validator_backend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static boolean validate(String email) {
		// TODO Auto-generated method stub
		if(validStart(email)==true){
			if(order(email)==true){
				return true;
			}
			else{ 
				return false;
			}
		}
		else{ 
			return false;
		}
	}
	//ensures entire email matches proper format
	public static boolean order(String email){
		// TODO Auto-generated method stub
		Pattern order = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matches = order.matcher(email);
		if(matches.find()){
			return true;
		}
		else 
			return false;
	
		}
	//Ensures first character is valid
	public static boolean validStart(String email) {
		// TODO Auto-generated method stub
		if(!(email.length()<=1||email.charAt(0)=='-')){
			return true;
		} 
		else 
			{
				return false;
			}
	}
}