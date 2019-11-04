import BreezySwing.*;
import javax.swing.*;
public class ParserGUI extends GBFrame{
	
	JTextField inputField = addTextField("",1,1,1,1);
	JButton enterButton = addButton("Enter",2,1,1,1);
	
	
	public void buttonClicked(JButton button) {
		if(button == enterButton) {
			Parser p = new Parser(inputField.getText());
			System.out.println(p.evaluate());
		}
	}
	
	public ParserGUI() {
		
	}
	
	public static void main(String[] args) {
		JFrame frm = new ParserGUI();
		frm.setVisible(true);
		frm.setSize(400,400);
		frm.setTitle("Expression Parser");
	}
}
