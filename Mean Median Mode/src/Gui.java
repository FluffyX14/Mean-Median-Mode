import javax.swing.*;
import BreezySwing.*;
public class Gui extends GBFrame {
	DoubleField input = addDoubleField (0, 1, 2, 1, 1);
	JButton enter = addButton("Add to List", 1, 2, 1, 1);
	JButton meanButton = addButton ("Mean", 2, 1, 1, 1);
	JButton medianButton = addButton ("Median", 2, 2, 1, 1);
	JButton modeButton = addButton ("Mode", 2, 3, 1, 1);
	JButton reset = addButton("Reset", 2, 4, 1, 1);
	double [] array = new double [26];
	int index = 0;
	int inputCounter = 0;
	Calculate calculator = new Calculate();
	JLabel counter = addLabel ("Number " + (inputCounter+1) + "/25:", 1, 1, 1, 1); //displays number of inputs
	

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enter) {
			if (input.getText().isBlank()) { //error checks for empty input
				messageBox("Please input a number");
			}
			else if (input.isValidNumber()) {
				if (inputCounter == 25) { //limits inputs to 25
					messageBox("You cannot input any more numbers");
				}
				else {
					array[index] = input.getNumber(); //enters input into array
					index++;
					inputCounter++;
					input.setText("");
					input.grabFocus();
					if (inputCounter == 25) { //tells when array is full
						counter.setText ("Sequence Filled");
					}
					else { //displays number of inputs
						counter.setText ("Number " + (inputCounter+1) + "/25");
					}
				}
			}
			else { //error checks for non-numbers
				messageBox("Invalid input");
			}
		}
		
		if (buttonObj == meanButton) {
			messageBox(calculator.getMean(array, inputCounter));
		}
		
		if (buttonObj == medianButton) {
			messageBox(calculator.getMedian(array, inputCounter));
		}
		
		if (buttonObj == modeButton) {
			String messageBoxOutput = "";
			calculator.getMode(array, inputCounter);
			for (int i = 0; i < calculator.getMode(array, inputCounter).size(); i++) {
				messageBoxOutput += calculator.getMode(array, inputCounter).get(i) + "   ";
			}
			messageBox("Mode(s)" + messageBoxOutput);
		}
		
		if (buttonObj == reset) { //resets all variables
			for (int i = 0; i < array.length; i++) {
				array[i] = 0;
				inputCounter = 0;
				index = 0;
				counter.setText ("Number " + (inputCounter+1) + "/25");
			}
		}
		
		
	}
	//outputs GUI
	public static void main(String[] args) {
		JFrame frm = new Gui();
		frm.setTitle("Longest Non-Decreasing Sequence");
		frm.setSize(600, 300);
		frm.setVisible(true);
	}
}