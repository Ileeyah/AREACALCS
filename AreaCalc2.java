import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaCalc2 extends JFrame {

	private final double pi = 3.14;
	private JPanel panel;
	private JLabel messageLabel;
	
	//Radio buttons
	private JRadioButton twoD;
	private JRadioButton threeD;
	private ButtonGroup radioButtonGroup;
	
	
	//data input field
	private JTextField radiusTextField;
	

	
	//define the width and height of the window 
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 200;
	
/**
 * Constructor 		
 */

public AreaCalc2() {
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
	
	messageLabel = new JLabel("Enter the radius of your shape");
	radiusTextField = new JTextField(10);

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
	panel.add(radiusTextField);
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
		String radius;
		String units = " units squared.";
		String calcArea = "";
		double result = 0.0;
		
	//get the radius 	
	radius = radiusTextField.getText();
	//if 2-d is selected
	if (e.getSource() == twoD) {
		//calculate the area of a circle
		calcArea = "The area of your circle is ";
		result = Double.parseDouble(radius) * Double.parseDouble(radius) * pi;
		
		
		
	}
	//if 3-d is selected
	else if (e.getSource() == threeD) {
		//calculate the surface area of a sphere
		calcArea = "The surface area of your sphere is ";
		result = 4 * pi * Double.parseDouble(radius) * Double.parseDouble(radius);
		
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
		
		new AreaCalc2(); 
}
}


