public class ErrorCheck {
	
	private String baseString = "";
	
	
	public ErrorCheck(String str) {
		baseString = str;
	}
	
	
//	public void check() throws IllegalFormatException {
//		try {
//			checkFormat();
//		}catch (Exception e) {
//			throw new IllegalFormatException("Must start")
//		}
//	}
//	
	
	public void checkEqualSignFormat() throws IllegalFormatException{
		if(baseString.charAt(0) != '=') {
			throw new IllegalFormatException("Must start with equals sign");
		}
		
	}
	
	
	
	
}
