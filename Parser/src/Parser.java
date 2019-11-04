import java.util.Stack;

public class Parser {

	private String raw;
	
	private Stack numbers = new Stack<Integer>();
	private Stack operators = new Stack<Character>();
	
	
	public Parser(String input) {
		raw = input;
		stripRaw();
	}
	
	
	public void stripRaw() {
		char[] arr = raw.toCharArray();
		String result = "";
		for(char c : arr) {
			if(!Character.isWhitespace(c)) {
				result+=c;
			}
		}
		raw = result;
	}
	
	public String getRaw() {
		return raw;
	}
	
//	private void readExpression() {
//		char[] split = raw.toCharArray();
//		
//		for(int i = 1; i < split.length-1; i++) {
//			char current = split[i];
//			char next = split[i+1];
//			if(Character.isDigit(current) && )
//		}
//		
//	}
	
	
	
}
