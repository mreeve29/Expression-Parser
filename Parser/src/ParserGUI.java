import BreezySwing.*;
import javax.swing.*;
public class ParserGUI extends GBFrame{
	
	//instance objects
	private JTextField inputField = addTextField("",1,1,3,1);
	private JButton enterButton = addButton("Enter",2,1,1,1);
	private JButton resetButton = addButton("Reset",2,2,1,1);
	private JButton exitButton = addButton("Exit",2,3,1,1);
	private JLabel resultLabel = addLabel("",3,1,3,1);
	
	
	//button listener
	public void buttonClicked(JButton button) {
		if(button == enterButton) {
			String input = stripInput(inputField.getText());
			
			Parser p = new Parser(input);	
			
			try {
				p.validate();
				p.setNums();
				p.evaluate();
			}catch (Exception e) {
				resultLabel.setText("Error: " + e.getMessage());
				inputField.requestFocusInWindow();
				return;
			}
			
			
			resultLabel.setText(p.toString());
		}else if(button == resetButton) {
			inputField.setText("");
			resultLabel.setText("");
		}else if(button == exitButton) {
			System.exit(1);
		}
	}
	
	//removes whitespace
	private String stripInput(String input) {
		char[] arr = input.toCharArray();
		String result = "";
		for(char c : arr) {
			if(!Character.isWhitespace(c)) {
				result+=c;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		JFrame frm = new ParserGUI();
		frm.setVisible(true);
		frm.setSize(400,400);
		frm.setTitle("Expression Parser");
	}
}
