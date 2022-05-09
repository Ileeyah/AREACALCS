import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaCalcSQ extends JFrame {

	
	private JPanel panel;
	private JLabel messageLabel;
	
	//Radio buttons
	private JRadioButton twoD;
	private JRadioButton threeD;
	private ButtonGroup radioButtonGroup;
	
	
	//data input field
	private JTextField sideTextField;
	

	
	//define the width and height of the window 
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 200;
	
/**
 * Constructor 		
 */

public AreaCalcSQ() {
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
	
	messageLabel = new JLabel("Enter a side of your shape");
	sideTextField = new JTextField(10);

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
	panel.add(sideTextField);
	panel.add(twoD);
	panel.add(threeD);
	

}

/**
 * Defines the event of a user clicking one of the radio buttons 
 * @author Ileeyah
 *
 */

private class RadioButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String side;
		String units = " units squared.";
		String calcArea = "";
		double result = 0.0;
		
	//get the side	
	side = sideTextField.getText();
	//if 2-d is selected 
	if (e.getSource() == twoD) {
		//calculate the area of a square
		calcArea = "The area of your square is ";
		result = Double.parseDouble(side) * Double.parseDouble(side);
		
		
	} 
	//if 3-d is selected
	else if (e.getSource() == threeD) {
		//calculate the surface area of a cube
		calcArea = "The surface area of your cube is ";
		result = 6 * Double.parseDouble(side) * Double.parseDouble(side);
	} 
	//display results
	JOptionPane.showMessageDialog(null, calcArea + result + units);
	}
}

/**
 * Main method creates an instance of the AreaCalc class
 * @param args
 */

public static void main(String[] args) 
{
		
		new AreaCalcSQ(); 
}
}
