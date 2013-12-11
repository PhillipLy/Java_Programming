// CS 112 Week 14 HomeWork
// By: Phillip Ly




/**
 *  Public enumeration for different states of the game
 */
public enum StateOfGame {
	INPROGRESS, TIE, EX_WON, CIRCLE_WON
}




/**
 * Public enumeration for the subsection and section of the contents
 */
public enum Subsection {
	EMPTY, EX, CIRCLE
}





import java.awt.*;

/**
 * The Section class for each individual section of the game board.
 */

public class Section {

	Subsection content; // content of this section of type subsection.
	int row, column; // row and column of this Section, not used in this program

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

	/** Paint itself on the graphics canvas, given the Graphics context */
	public void paint(Graphics g) {
		// Use Graphics2D which allows us to set the pen's stroke
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(TicTacToeGameMain.SYMBOL_STROKE_WIDTH,
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Graphics2D
		// only
		// Draw the Section if it is not empty
		int x1 = column * TicTacToeGameMain.CELL_SIZE
				+ TicTacToeGameMain.CELL_PADDING;
		int y1 = row * TicTacToeGameMain.CELL_SIZE
				+ TicTacToeGameMain.CELL_PADDING;
		if (content == Subsection.EX) {
			g2d.setColor(Color.RED);
			int x2 = (column + 1) * TicTacToeGameMain.CELL_SIZE
					- TicTacToeGameMain.CELL_PADDING;
			int y2 = (row + 1) * TicTacToeGameMain.CELL_SIZE
					- TicTacToeGameMain.CELL_PADDING;
			g2d.drawLine(x1, y1, x2, y2);
			g2d.drawLine(x2, y1, x1, y2);
		} else if (content == Subsection.CIRCLE) {
			g2d.setColor(Color.BLUE);
			g2d.drawOval(x1, y1, TicTacToeGameMain.SYMBOL_SIZE,
					TicTacToeGameMain.SYMBOL_SIZE);
		}
	}
}







import java.awt.*;
/**
 * The Board class for the ROWS-by-COLS game-board.
 */
public class GameBoard {

	Section[][] sections; // establishes 2D array of ROWS-by-COLS Cell instances

	/** Constructor to initialize the game board */
	public GameBoard() {
		sections = new Section[TicTacToeGameMain.ROWS][TicTacToeGameMain.COLS]; // allocate the array into the respective sections
		for (int row = 0; row < TicTacToeGameMain.ROWS; ++row) {
			for (int col = 0; col < TicTacToeGameMain.COLS; ++col) {
				sections[row][col] = new Section(row, col); // allocate element of array
			}
		}
	}

	/** Initialize (or re-initialize) the game board */
	public void init() {
		for (int row = 0; row < TicTacToeGameMain.ROWS; ++row) {
			for (int col = 0; col < TicTacToeGameMain.COLS; ++col) {
				sections[row][col].emptyContent(); // clear the section content
			}
		}
	}

	/** Return true if it is a tie (i.e., no more EMPTY section) */
	public boolean isTie() {
		for (int row = 0; row < TicTacToeGameMain.ROWS; ++row) {
			for (int col = 0; col < TicTacToeGameMain.COLS; ++col) {
				if (sections[row][col].content == Subsection.EMPTY) {
					return false; // an empty subsection found, not a draw, exit
				}
			}
		}
		return true; // no empty section, it's a draw
	}

	/** Return true if the player with "seed" is victorious after placing at
       (subsectionRow, subsectionCol) */
	public boolean isVictorious(Subsection subsection, int subsectionRow, int subsectionCol) {
		return (sections[subsectionRow][0].content == subsection   // 3-in-a-row
				&& sections[subsectionRow][1].content == subsection
				&& sections[subsectionRow][2].content == subsection
				|| sections[0][subsectionCol].content == subsection // 3-in-a-column
				&& sections[1][subsectionCol].content == subsection
				&& sections[2][subsectionCol].content == subsection
				|| subsectionRow == subsectionCol              // 3 diagonally
				&& sections[0][0].content == subsection
				&& sections[1][1].content == subsection
				&& sections[2][2].content == subsection
				|| subsectionRow + subsectionCol == 2          // 3 opposite diagonally
				&& sections[0][2].content == subsection
				&& sections[1][1].content == subsection
				&& sections[2][0].content == subsection);
	}

	/** Paint itself to instantiate graphically*/
	public void paint(Graphics g) {
		// Draw the grid-lines
		g.setColor(Color.BLACK);
		for (int row = 1; row < TicTacToeGameMain.ROWS; ++row) {
			g.fillRoundRect(0, TicTacToeGameMain.CELL_SIZE * row - TicTacToeGameMain.GRID_WIDHT_HALF,
					TicTacToeGameMain.CANVAS_WIDTH - 1, TicTacToeGameMain.GRID_WIDTH,
					TicTacToeGameMain.GRID_WIDTH, TicTacToeGameMain.GRID_WIDTH);
		}
		for (int col = 1; col < TicTacToeGameMain.COLS; ++col) {
			g.fillRoundRect(TicTacToeGameMain.CELL_SIZE * col - TicTacToeGameMain.GRID_WIDHT_HALF, 0,
					TicTacToeGameMain.GRID_WIDTH, TicTacToeGameMain.CANVAS_HEIGHT - 1,
					TicTacToeGameMain.GRID_WIDTH, TicTacToeGameMain.GRID_WIDTH);
		}

		// Draw all the sections
		for (int row = 0; row < TicTacToeGameMain.ROWS; ++row) {
			for (int col = 0; col < TicTacToeGameMain.COLS; ++col) {
				sections[row][col].paint(g);  // ask the section to paint itself
			}
		}
	}
}








import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Tic-Tac-Toe Game: Two-player Graphic version.
 */
@SuppressWarnings("serial")
public class TicTacToeGameMain extends JPanel {
	// Declarations for the game board
	public static final int ROWS = 3;  // ROWS by COLS cells
	public static final int COLS = 3;
	public static final String TITLE = "Tic Tac Toe: The Game. Fun and Addictive!";

	// Name-constants for the various dimensions used for graphics drawing
	public static final int CELL_SIZE = 100; // Section width and height 
	public static final int CANVAS_WIDTH = CELL_SIZE * COLS;  
	public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
	public static final int GRID_WIDTH = 8;  // Grid-line's width
	public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2; // Grid-line's half-width
	// Symbols (ex/circle) are displayed inside a section
	public static final int CELL_PADDING = CELL_SIZE / 6;
	public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
	public static final int SYMBOL_STROKE_WIDTH = 8; // pen's stroke width

	private GameBoard board;            // the game board
	private StateOfGame currentState; // the current state of the game
	private Subsection currentPlayer;     // the current player
	private JLabel statusBar;       //  displays status message

	/** Game Constructor */
	public TicTacToeGameMain() {

		// This JPanel initiates MouseEvent
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {  // handle mouse-clicks 
				int mouseX = e.getX();
				int mouseY = e.getY();
				// Clicks to get the row and column 
				int rowSelected = mouseY / CELL_SIZE;
				int colSelected = mouseX / CELL_SIZE;

				if (currentState == StateOfGame.INPROGRESS) {
					if (rowSelected >= 0 && rowSelected < ROWS
							&& colSelected >= 0 && colSelected < COLS
							&& board.sections[rowSelected][colSelected].content == Subsection.EMPTY) {
						board.sections[rowSelected][colSelected].content = currentPlayer; // move
						updateGame(currentPlayer, rowSelected, colSelected); // update currentState
						// Switch player
						currentPlayer = (currentPlayer == Subsection.EX) ? Subsection.CIRCLE : Subsection.EX;
					}
				} else {        // game ends
					initGame();  // re-launch the game
				}
				// Refreshing canvas' painting
				repaint();  // Call paintComponent().
			}
		});

		// Setup the status bar (JLabel) to display status message
		statusBar = new JLabel("         ");
		statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 14));
		statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
		statusBar.setOpaque(true);
		statusBar.setBackground(Color.LIGHT_GRAY);

		setLayout(new BorderLayout());
		add(statusBar, BorderLayout.PAGE_END); 
		setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT + 30));
		//  statusBar'sheight

		board = new GameBoard();   // allocate the game-board accordingly
		initGame();  // Initialize the game variables
	}

	/** Initialize the game-board contents and the current-state */
	public void initGame() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				board.sections[row][col].content = Subsection.EMPTY; // all sections not filled/empty
			}
		}
		currentState = StateOfGame.INPROGRESS;  // ready to play
		currentPlayer = Subsection.EX;        // EX go first
	}

	/** Update the currentState after the player with "theSection" has placed on (row, col) */
	public void updateGame(Subsection theSection, int row, int col) {
		if (board.isVictorious(theSection, row, col)) {  // check for victory condition
			currentState = (theSection == Subsection.EX) ? StateOfGame.EX_WON : StateOfGame.CIRCLE_WON;
		} else if (board.isTie()) {  // check for tie
			currentState = StateOfGame.TIE;
		}
		// Otherwise, no change to current state of game (INPROGRESS).
	}

	/** Custom painting codes on this JPanel */
	@Override
	public void paintComponent(Graphics g) {  // invoke by repaint()
		super.paintComponent(g);    // fill background components
		setBackground(Color.WHITE); // set color for background 

		board.paint(g);  // ask the game board to paint accordingly

		// Display Status-bar message
		if (currentState == StateOfGame.INPROGRESS) {
			statusBar.setForeground(Color.BLACK);
			if (currentPlayer == Subsection.EX) {
				statusBar.setForeground(Color.RED);
				statusBar.setText("It is Player X's Turn");
			} else {
				statusBar.setForeground(Color.BLUE);
				statusBar.setText("It is Player O's Turn");
			}
		} else if (currentState == StateOfGame.TIE) {
			statusBar.setForeground(Color.RED);
			statusBar.setText("It's a Tie! Click to restart game");
		} else if (currentState == StateOfGame.EX_WON) {
			statusBar.setForeground(Color.RED);
			statusBar.setText("Player X Won! Click to restart game");
		} else if (currentState == StateOfGame.CIRCLE_WON) {
			statusBar.setForeground(Color.BLUE);
			statusBar.setText("Player O Won! Click to restart game");
		}
	}

	/** The entry "main" method */
	public static void main(String[] args) {
		// Run GUI construction codes in Event-Dispatching thread for thread safety
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame(TITLE);
				// Set the content-pane of the JFrame corresponding to an instance of the main JPanel
				frame.setContentPane(new TicTacToeGameMain());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setLocationRelativeTo(null); // put the application window at center
				frame.setVisible(true);            // displays it
			}
		});
	}
}

// Good, Phillip









// Extra features: optional to add (recomend to run the program without these features first)

// running as an applet
//if using eclipse, one can use "appletviewer" without an HTML file


import javax.swing.*;

/** Applet for .... */
@SuppressWarnings("serial")
public class SwingTemplateJApplet extends JApplet {
 
   /** init() to setup the UI components */
   @Override
   public void init() {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      try {
         // Use invokeAndWait() to ensure that init() exits after GUI construction
         SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
               // Set the content-pane of "this" JApplet to an instance of main JPanel
               setContentPane(new SwingTemplateJPanel());
            }
         });
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}










// For adding sound effect: one sound is as the player makes the move, the other is when the game is over

// add the following to the TicTacToeGameMain.java


//Add the import statements 
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

......

//Declare the following variables for the sound clips in the TicTacToeGameMain class
String fileMove = "sounds/move.wav";         // audio filename for move effect
String fileGameOver = "sounds/gameover.wav"; // audio filename for game-over effect
Clip soundClipMove;      // Sound clip for move effect
Clip soundClipGameOver;  // Sound clip for game-over effect

......

//In the main TicTacToeGameMain's Constructor
try {
URL url = this.getClass().getClassLoader().getResource(fileGameOver);
if (url == null) {
   System.err.println("Couldn't find file: " + fileGameOver);
} else {
   AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
   soundClipGameOver = AudioSystem.getClip();
   soundClipGameOver.open(audioIn);
}
    
url = this.getClass().getClassLoader().getResource(fileMove);
if (url == null) {
   System.err.println("Couldn't find file: " + fileMove);
} else {
   AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
   soundClipMove = AudioSystem.getClip();
   soundClipMove.open(audioIn);
}
} catch (UnsupportedAudioFileException e) {
System.err.println("Audio Format not supported!");
} catch (Exception e) {
e.printStackTrace();
}

......

//In mouseClicked() event-handler - play sound effect upon mouse-click
if (currentState == GameState.PLAYING) {
if (soundClipMove.isRunning()) soundClipMove.stop();
soundClipMove.setFramePosition(0); // rewind to the beginning
soundClipMove.start();             // Start playing
} else {
if (soundClipGameOver.isRunning()) soundClipGameOver.stop();
soundClipGameOver.setFramePosition(0); // rewind to the beginning
soundClipGameOver.start();             // Start playing
}












