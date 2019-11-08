public class Parser {

	//instance objects
	private String raw;
	
	//instance variables
	private int num1,num2;
	private char operator;
	private double result = 0;
	
	//constructor
	public Parser(String input) {
		raw = input;
	}
	
	//gets ands sets num1 and num2 from string
	public void setNums() throws IllegalFormatException{
		String numsStr = "";
		char[] split = raw.toCharArray();
		for(int i = 1; i < split.length - 1; i++) {
			if(split[i] == '-' && Character.isDigit(split[i+1]) && !Character.isDigit(split[i-1])) {
				numsStr += split[i];
				continue;
			}
			if(Character.isDigit(split[i])) {
				numsStr += split[i];
			}
			if(isOperator(split[i]) || split[i] == '-') {
				operator = split[i];
				numsStr += " ";
				numsStr += raw.substring(i+1,raw.length());
				break;
			}
		}
		System.out.println(numsStr);
		String[] nums = numsStr.split(" ");
		
		if(nums.length <= 1) throw new IllegalFormatException("Cannot enter one number");
		
		num1 = Integer.parseInt(nums[0]);
		if(num2Check(nums[1]))throw new IllegalFormatException("Too many numbers/operators");
		num2 = Integer.parseInt(nums[1]);
		
	}
	
	private boolean isOperator(char c) {
		if(c == '-' || c == '+' || c == '/' || c == '*') {
			return true;
		}
		return false;
	}
	
	//evaluates the expression
	public double evaluate() throws DivideByZeroException{
		switch(operator) {
		case '-':
			result = num1 - num2;
			break;
		case '+':
			result = num1 + num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			if(num2 == 0)throw new DivideByZeroException("Cannot divide by 0");
			result = (double)num1/(double)num2;
			break;
		default:
			break;
		}
		return result;
	}
	
	//outputs answer and formats it
	public String toString() {
		//if result is whole number
		if(result == (int)result) {
			return Integer.toString((int)result);
		}else {
			return "" + result;
		}
	}
	
	//error checking method
	public void validate() throws IllegalFormatException, IllegalCharacterException {
		char[] split = raw.toCharArray();
		
		if (split.length <=1) throw new IllegalFormatException("Illegal format");
		
		if(raw.charAt(0) != '=') {
			throw new IllegalFormatException("Must start with equals sign");
		}
			
		for(int i = 1; i < split.length; i++) {
			char c = split[i];
			if(!Character.isDigit(c) && !isOperator(c)) {
				throw new IllegalCharacterException("Illegal Character");
			}
		}
		
		
		if (isOperator(split[1]) && split[1] != '-') {
			throw new IllegalFormatException("\'" + split[1] + "\'" + " Cannot lead the expression");
		}
		
		if(isOperator(split[1]) && isOperator(split[2]))
			throw new IllegalFormatException("Can't have two leading operators");
		
		for(int i = 1; i < split.length-1; i++) {
			char c = split[i];
			char h = split[i+1];
			if(isOperator(c) && isOperator(h) && (c != '-' && h != '-' || !Character.isDigit(split[i-1]))) {
				throw new IllegalFormatException("Too many operators");
			}
		}
		
		
	}
	
	//special checks for num2. which is a string before parsed
	private boolean num2Check(String str) {
		char[] split = str.toCharArray();
		if(split.length == 1 && !Character.isDigit(split[0]))return true;
		if(split.length > 0) {
			if(split[0] != '-' && !Character.isDigit(split[0]))return true;
		}
		for(int i = 1; i < split.length; i++) {
			if(!Character.isDigit(split[i]))return true;
		}
		return false;
	}
	
}