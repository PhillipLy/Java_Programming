import javax.swing.JOptionPane;

public class rock_paper_scissor_game_GUI {

	public static void main(String[] args) {
		  // Prompt for the user to choose from the options
		  String userInput = JOptionPane.showInputDialog(
		    "Please enter rock, paper, or scissor:");
		  // Convert to lower case in case they type in capitals
		  userInput = userInput.toLowerCase();
		  
		  // Generates a random number corresponding to the three possible choices
		  // Scissor (0),  rock (1), paper (2)
		  int random = (int)(Math.random() * 3);
		  String computerInput; // CPU's choice
		  if (random == 0) 
		   computerInput = "rock";
		  else if (random == 1)
		   computerInput = "paper";
		  else
		   computerInput = "scissor";
		  
		  String message = "The computer chose " + computerInput + ". You chose "
		    + userInput;
		  
		  // Determine who win
		  boolean isTie = computerInput.equals(userInput);
		  boolean isWin = 
		   ((computerInput.equals("rock") && userInput.equals("scissor")) ||
		   (computerInput.equals("paper") && userInput.equals("rock")) ||
		   (computerInput.equals("scissor") && userInput.equals("paper")));
		  
		  // Messages after determining who win
		  if (isWin)
		   message += ". Computer Won.";
		  else if (isTie)
		   message += " too. It is Tie";
		  // There are 3 options, computer win, tie, or you win
		  // So we don't have to test here, if the code reach here, human win.
		  else
		   message += ". You Won";
		   
		  
		  // Display the result on the screen
		  JOptionPane.showMessageDialog(null, message);
		 }
	
}
// Good
