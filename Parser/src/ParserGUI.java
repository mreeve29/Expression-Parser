import BreezySwing.*;
import javax.swing.*;
public class ParserGUI extends GBFrame{
	
	JTextField inputField = addTextField("",1,1,3,1);
	JButton enterButton = addButton("Enter",2,1,1,1);
	JButton resetButton = addButton("Reset",2,2,1,1);
	JButton exitButton = addButton("Exit",2,3,1,1);
	JLabel resultLabel = addLabel("",3,1,1,2);
	
	
	
	public void buttonClicked(JButton button) {
		if(button == enterButton) {
			String input = stripInput(inputField.getText());
			ErrorCheck error = new ErrorCheck(input);
			
			try {
				error.checkEqualSignFormat();
			}catch (Exception e) {
				messageBox(e.getMessage());
			}
			
			
			
			Parser p = new Parser(input);
			resultLabel.setText(p.toString());
		}else if(button == resetButton) {
			inputField.setText("");
			resultLabel.setText("");
		}else if(button == exitButton) {
			System.exit(1);
		}
	}
	
	public String stripInput(String input) {
		char[] arr = input.toCharArray();
		String result = "";
		for(char c : arr) {
			if(!Character.isWhitespace(c)) {
				result+=c;
			}
		}
		return result;
	}
	
	
	
	public ParserGUI() {
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\20mreeve\\Pictures\\halp.jpg")));
		
	}
	
	public static void main(String[] args) {
		JFrame frm = new ParserGUI();
		frm.setVisible(true);
		frm.setSize(400,400);
		frm.setTitle("Expression Parser");
	}
}
