public class Parser {

	private String raw;
	
	public Parser(String input) {
		raw = input;
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
}
