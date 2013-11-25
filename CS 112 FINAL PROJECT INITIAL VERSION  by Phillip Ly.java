/**
 * Public enumeration for the subsection and section of the contents
 */
public enum Subsection {
	EMPTY, EX, CIRCLE
}


/**
 *  Public enumeration for different states of the game
 */

public enum StateOfGame {
	INPROGRESS, TIE, EX_WON, CIRCLE_WON
}


/**
 * The Section class models for each individual section of the game board.
 */

public class Section {

	// package access
	Subsection content; // content of this section of type subsection.
	// take a value of Subsection.EMPTY, Subsection.EX, or Subsection.CIRCLE
	int row, column; // row and column of this cell, not used in this program

	/** Constructor to initialize this cell */
	public Section(int row, int column) {
		this.row = row;
		this.column = column;
		emptyContent(); // clear content
	}

	/** Clear the section content to EMPTY */
	public void emptyContent() {
		content = Subsection.EMPTY;
	}

	/** Paint itself */
	public void paint() {
		switch (content) {
		case EX:
			System.out.print(" X ");
			break;
		case CIRCLE:
			System.out.print(" O ");
			break;
		case EMPTY:
			System.out.print("   ");
			break;
		}
	}
}



/**
 * The GameBoard class models the game-board.
 */

public class GameBoard {
	// Named-constants for the dimensions
	public static final int ROWS = 3;
	public static final int COLS = 3;

	// package access
	Section[][] sections; // a board composes of ROWS-by-COLS Section instances
	int currentRow, currentCol; // the current subsection's row and column

	/** Constructor to initialize the game board */
	public GameBoard() {
		sections = new Section[ROWS][COLS]; // allocate the array
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				sections[row][col] = new Section(row, col); // allocate element
				// of the array
			}
		}
	}

	/** Initialize (or re-initialize) the contents of the game board */
	public void initialize() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				sections[row][col].emptyContent(); // clear the section content
			}
		}
	}

	/** Return true if it is a tie (i.e., no more EMPTY section) */
	public boolean isTie() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (sections[row][col].content == Subsection.EMPTY) {
					return false; // an empty subsection found, not a draw, exit
				}
			}
		}
		return true; // no empty section, it's a tie
	}

	/**
	 * Return true if the player with "theSection" is victorious after placing at
	 * (currentRow, currentCol)
	 */
	public boolean isVictorious(Subsection theSection) {
		return (sections[currentRow][0].content == theSection // 3-in-the-row
				&& sections[currentRow][1].content == theSection
				&& sections[currentRow][2].content == theSection
				|| sections[0][currentCol].content == theSection // 3-in-the-column
				&& sections[1][currentCol].content == theSection
				&& sections[2][currentCol].content == theSection
				|| currentRow == currentCol // 3-in-the-diagonal
				&& sections[0][0].content == theSection
				&& sections[1][1].content == theSection
				&& sections[2][2].content == theSection || currentRow
				+ currentCol == 2 // 3-in-the-opposite-diagonal
				&& sections[0][2].content == theSection
				&& sections[1][1].content == theSection
				&& sections[2][0].content == theSection);
	}

	/** Paint itself */
	public void paint() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				sections[row][col].paint(); // each subsection of the game board
				// paints itself
				if (col < COLS - 1)
					System.out.print("|");
			}
			System.out.println();
			if (row < ROWS - 1) {
				System.out.println("-----------");
			}
		}
	}
}




import java.util.Scanner;

public class TicTacToeGameMain {
	private GameBoard board; // the game board
	private StateOfGame currentState; // the current state of the game (of enum
	// StateOfGame)
	private Subsection currentPlayer; // the current player (of enum Subsection)

	private static Scanner in = new Scanner(System.in); // input Scanner

	/** Constructor to setup the game */
	public TicTacToeGameMain() {
		board = new GameBoard(); // allocate game-board

		// Initialize the game-board and current status
		initializeGame();
		// Play the game once. Players EX and CIRCLE move alternately.
		do {
			playerDecision(currentPlayer); // update the content, currentRow and
			// currentCol
			board.paint(); // ask the board to paint itself
			updateGame(currentPlayer); // update currentState
			// Print message if game-over
			if (currentState == StateOfGame.EX_WON) {
				System.out.println("'X' is victorious! Bye!");
			} else if (currentState == StateOfGame.CIRCLE_WON) {
				System.out.println("'O' is victorious! Bye!");
			} else if (currentState == StateOfGame.TIE) {
				System.out.println("It's a Tie! Bye!");
			}
			// Switch player
			currentPlayer = (currentPlayer == Subsection.EX) ? Subsection.CIRCLE
					: Subsection.EX;
		} while (currentState == StateOfGame.INPROGRESS); // repeat until game-over
	}

	/** Initialize the game-board contents and the current states */
	public void initializeGame() {
		board.initialize(); // clear the board contents
		currentPlayer = Subsection.EX; // EX plays first
		currentState = StateOfGame.INPROGRESS; // ready to play
	}

	/**
	 * The player with "theSection" makes one move, with input validation. Update
	 * Subsection's content, GameBoard's currentRow and currentCol.
	 */
	public void playerDecision(Subsection theSection) {
		boolean validInput = false; // for validating input
		do {
			if (theSection == Subsection.EX) {
				System.out
				.print("Player 'X', enter your decision (row[1-3] column[1-3]) For example, enter 2 2 for the center: ");
			} else {
				System.out
				.print("Player 'O', enter your decision (row[1-3] column[1-3]) For example, enter 2 2 for the center: ");
			}
			int row = in.nextInt() - 1;
			int col = in.nextInt() - 1;
			if (row >= 0 && row < GameBoard.ROWS && col >= 0 && col < GameBoard.COLS
					&& board.sections[row][col].content == Subsection.EMPTY) {
				board.sections[row][col].content = theSection;
				board.currentRow = row;
				board.currentCol = col;
				validInput = true; // input okay, exit loop
			} else {
				System.out.println("This move at (" + (row + 1) + ","
						+ (col + 1) + ") is not valid. Please try again...");
			}
		} while (!validInput); // repeat until input is valid
	}

	/** Update the currentState after the player with "theSection" has moved */
	public void updateGame(Subsection theSection) {
		if (board.isVictorious(theSection)) { // check for victorious condition
			currentState = (theSection == Subsection.EX) ? StateOfGame.EX_WON
					: StateOfGame.CIRCLE_WON;
		} else if (board.isTie()) { // check for tie
			currentState = StateOfGame.TIE;
		}
		// Otherwise, no change to current state (still StateOfGame.INPROGRESS).
	}

	/** The entry main() method */
	public static void main(String[] args) {
		new TicTacToeGameMain(); // Let the constructor do the job
	}
}
