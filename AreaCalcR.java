import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaCalcR extends JFrame {

	
	private JPanel panel;
	private JLabel messageLabel;
	
	//Radio buttons
	private JRadioButton twoD;
	private JRadioButton threeD;
	private ButtonGroup radioButtonGroup;
	
	
	//data input fields 
	private JTextField widthTextField;
	private JTextField lengthTextField;
	private JTextField baseTextField;

	
	//define the width and height of the window 
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 200;
/**
 * Constructor 		
 */

public AreaCalcR() {
	//set title
	setTitle("Area/Surface Area Calculator");
	
	//set the size of the window
	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	
	//set the close button to close the window when clicked 
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//build the panel
	buildPanel();
	//and the panel to frame 
	add(panel);
	
	//display the window
	setVisible(true);
			
	
}

/**
 * Method adds label, text fields, and button group  
 */

private void buildPanel() {
	
	messageLabel = new JLabel("Enter the length, width, and base of your shape.");
	lengthTextField = new JTextField(10);
	widthTextField = new JTextField(10);
	baseTextField = new JTextField(10);
	twoD = new JRadioButton("2-D");
	threeD = new JRadioButton("3-D");

	
	
	//group the buttons together
	radioButtonGroup = new ButtonGroup();
	radioButtonGroup.add(twoD);
	radioButtonGroup.add(threeD);
	
	
	//add active listeners 
	twoD.addActionListener(new RadioButtonListener());
	threeD.addActionListener(new RadioButtonListener());

	
	//create a panel with all of the components 
	panel = new JPanel();
	panel.add(messageLabel);
	panel.add(lengthTextField);
	panel.add(widthTextField);
	panel.add(baseTextField);
	panel.add(twoD);
	panel.add(threeD);
	

}

/**
 * Define the event of a user clicking one of the radio buttons 
 * @author Ileeyah
 *
 */

private class RadioButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String length;
		String width;
		String base;
		String calcArea = "";
		String units = " units squared.";
		double result = 0.0;
		
	//get the length 	
	length = lengthTextField.getText();
	//get the width
	width = widthTextField.getText();
	//get the base
	base = baseTextField.getText();
	//if 2-d is selected
	if (e.getSource() == twoD) {
		//calculate the area of a rectangle
		calcArea = "The area of your rectangle is ";
		result = Double.parseDouble(length) * Double.parseDouble(width);
		
		
	} 
	//if 3-d is selected 
	else if (e.getSource() == threeD) {
		//calculate the surface area of a rectangular prism
		calcArea = "The surface area of your rectangular prism is ";
		result = 2 * Double.parseDouble(width) * Double.parseDouble(length) 
				+ 2 * Double.parseDouble(length) * Double.parseDouble(base) 
				+ 2 * Double.parseDouble(width) * Double.parseDouble(base);
		
		} 
	//display the results
	JOptionPane.showMessageDialog(null, calcArea + result + units);
	}
}

/**
 * Main method creates an instance of the AreaCalc class
 * @param args
 */

public static void main(String[] args) 
{
		
		new AreaCalcR(); 
}
}

