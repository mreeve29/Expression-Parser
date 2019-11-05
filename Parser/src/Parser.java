public class Parser {

	private String raw;
	
	private int num1,num2;
	
	private char operator;
	
	private double result;
	
	public Parser(String input) {
		raw = input;
		setNums();
		evaluate();
	}
	
	public String getRaw() {
		return raw;
	}
	
	private void setNums() {
		String numsStr = "";
		char[] split = raw.toCharArray();
		for(int i = 0; i < split.length - 1; i++) {
			if(split[i] == '-' && Character.isDigit(split[i+1])) {
				numsStr += split[i];
				continue;
			}
			if(Character.isDigit(split[i])) {
				numsStr += split[i];
			}
			if(isOperator(split[i])) {
				operator = split[i];
				numsStr += " ";
				numsStr += raw.substring(i+1,raw.length());
				break;
			}
		}
		
		String[] nums = numsStr.split(" ");
		
		try {
			num1 = Integer.parseInt(nums[0]);
			num2 = Integer.parseInt(nums[1]);
		}catch(IllegalFormatException e) {
			
		}
		
	}
	
	private boolean isOperator(char c) {
		if(c == '-' || c == '+' || c == '/' || c == '*') {
			return true;
		}
		return false;
	}
	
	
	public double evaluate() {
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
			result = (double)num1/(double)num2;
			break;
		default:
			break;
		}
		return result;
	}
	
	public String toString() {
		if(isInt(result)) {
			return Integer.toString((int)result);
		}else {
			return "" + result;
		}
	}
	
	private boolean isInt(double x) {
		if(x == (int)x) {
			return true;
		}else return false;
	}
	
}