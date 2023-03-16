// Assignment #: 11
// Name: Takahiro Wada
// StudentID: 1216601204
// Description: Checker class checks if the input string have matching
//        parantheses, brackets, and braces.

import java.util.*;

public class Checker
{
	
	public static String check(String lineToCheck)
	{		
		String A = ")";			//Our Tokens
		String B = "]";
		String C = "}";
		Stack<Character> myStack = new Stack<>();	//New Stack
		int i = 0;		//index set to zero
		
		while(i < lineToCheck.length())		//Traverses through stack
		{
			
			if(lineToCheck.charAt(i) == '(' || lineToCheck.charAt(i) == '{' || lineToCheck.charAt(i) == '[')	//Checks for "open" parantheses, brackets, and braces
			{
				
				myStack.push(lineToCheck.charAt(i));		//Pushes any "open" symbols from the string
				
			}
			//Checks for "closed" parantheses, brackets, or braces in the beginning of string OR checks for mismatched parantheses, brackets, or braces
			else if((lineToCheck.charAt(0) == ')' || lineToCheck.charAt(0) == '}' || lineToCheck.charAt(0) == ']') || ((lineToCheck.charAt(i) == ')' && myStack.peek() != '(') || (lineToCheck.charAt(i) == '}' && myStack.peek() != '{') || (lineToCheck.charAt(i) == ']' && myStack.peek() != '[')))
			{	
				
				return lineToCheck.charAt(i) + " at the position " + (i) + " does not match."; 
				
			}
			//Checks to see if parantheses, brackets, or braces are matched, then removes out of stack if matched
			else if((myStack.empty() == false) && ((lineToCheck.charAt(i) == ')' && myStack.peek() == '(') || (lineToCheck.charAt(i) == '}' && myStack.peek() == '{') || (lineToCheck.charAt(i) == ']' && myStack.peek() == '[')))
			{

				myStack.pop(); 		//Removed top element of the stack
				
			}
			
			i++;		//Increment index i
			
		}
		
		if(myStack.isEmpty() == false)	
		{
			
			if(lineToCheck.charAt(lineToCheck.length() - 1) != ')' && myStack.peek() == '(')	//Checks if parantheses is missing 
			{
				
				return A + " is missing.";
				
			}
			
			else if(lineToCheck.charAt(lineToCheck.length() - 1) != ']' && myStack.peek() == '[')	//Checks if brackets is missing
			{
				
				return B + " is missing.";
				
			}
			
			else if(lineToCheck.charAt(lineToCheck.length() - 1) != '}' && myStack.peek() == '{')	//Checks if braces is missing
			{
				
				return C + " is missing.";
				
			}
			
		}
		
		return "Everything is matched!";		//Output if everything is matching
		
	}
	
}
  