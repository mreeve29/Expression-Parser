public class Parser {

	private String raw;
	
	private int num1,num2;
	
	private char operator;
	
	public Parser(String input) {
		raw = input;
		stripRaw();
		setNums();
	}
	
	
	public void stripRaw() {
		char[] arr = raw.toCharArray();
		String result = "";
		for(char c : arr) {
			if(!Character.isWhitespace(c)) {
				result+=c;
			}
		}
		raw = result.substring(1);
		System.out.println(raw);
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
				System.out.println("Number: " + split[i] + " at " + i);
			}
			if(isOperator(split[i])) {
				operator = split[i];
				numsStr += " ";
				numsStr += raw.substring(i+1,raw.length());
				break;
			}
		}
		
		String[] nums = numsStr.split(" ");
		num1 = Integer.parseInt(nums[0]);
		num2 = Integer.parseInt(nums[1]);
	}
	
	private boolean isOperator(char c) {
		if(c == '-' || c == '+' || c == '/' || c == '*') {
			return true;
		}
		return false;
	}
	
	
	public double evaluate() {
		double result = 0;
		
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
	
}