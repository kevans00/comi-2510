import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

public class AssignmentZero {
	
//Initializing the logger
	
private static final Logger logger = LogManager.getLogger(AssignmentZero.class.getName());
	
public static Logger getLogger() {
		return AssignmentZero.logger; 
		}
	
//Name validation checks

public static boolean validateName(String str) {
	
	//https://www.guinnessworldrecords.com/world-records/67285-longest-personal-name
	//The longest personal name - 747 characters
	int RECORD_NAME_LENGTH = 747;
	
	//An array list containing all acceptable characters
	ArrayList<Character> a = new ArrayList<Character>();
    String b="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(int i=0;i<b.length();i++){
        a.add(b.charAt(i));
    }
    
	//Remove spaces so they don't count as extra characters while validating
	String nameNoSpace = str.replaceAll("\\s", "");
	
	//Check if the user input is blank
	if (nameNoSpace.isEmpty()) {
		JOptionPane.showMessageDialog(null, "You haven't entered anything - try again.", "Error Message", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	//Since the user input something, now we can move on to validation
	else {
		
		//Check if the name contains numbers
		for (int i = 0; i < nameNoSpace.length(); i++) { 
		    if (nameNoSpace.matches(".*\\d.*")) {
		    	AssignmentZero.logger.debug("Character at index " + i + " contains " + nameNoSpace.charAt(i));
		    	JOptionPane.showMessageDialog(null, "Cannot contain numbers - please try again", "Error Message", JOptionPane.ERROR_MESSAGE);
		    	return false;
		    } 
		}
		
		//Check if the name contains special characters
		for (int i = 0; i < nameNoSpace.length(); i++) {
			if (!a.contains(nameNoSpace.charAt(i))) {
				AssignmentZero.logger.debug("Character at index " + i + " contains " + nameNoSpace.charAt(i));
		    	JOptionPane.showMessageDialog(null, "Cannot contain special characters - please try again.", "Error Message", JOptionPane.ERROR_MESSAGE);
		    	return false;
			}
		}
		
		//Check if the name length exceeds the limit
		if (nameNoSpace.length() > RECORD_NAME_LENGTH) {
			JOptionPane.showMessageDialog(null, "This is too long - try again.", "Error Message", JOptionPane.ERROR_MESSAGE);
			AssignmentZero.logger.debug("Length of name is equal to: " + nameNoSpace.length());
			return false;
		}
		
		//From here there should be no issues, so the name is displayed
		else {
			//The option pane that displays your name
			JOptionPane.showMessageDialog(null, str, "Your Name!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	return true;
}

//The main function - asks user for name, validates input, repeats until valid
public static void main(String[] args) {
	
	//Ask the user for their name
	String name = JOptionPane.showInputDialog("What is your name?");
	
	//Validate the name
	boolean isValid = validateName(name);
	
	//Repeats if the input is invalid
	while (!isValid) {
		name = JOptionPane.showInputDialog("What is your name?");
		isValid = validateName(name);
		AssignmentZero.logger.debug("Name is validated to be: " + isValid + " with " + name + " as the name.");
		}
	}
}
