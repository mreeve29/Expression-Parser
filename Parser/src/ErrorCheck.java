public class ErrorCheck {
	
	private String baseString = "";
	
	
	public ErrorCheck(String str) {
		baseString = str;
	}
	
	
	public String check() throws IllegalFormatException {
		String error = "NOERROR";
		
		if(baseString.charAt(0) != '=') {
			error = "Must start with equals sign";
			throw new IllegalFormatException("Must start with equals sign");
		}
		
		
		
		
		return error;
	}
	
	
}
