import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUITicTacToe implements ActionListener{

	JFrame frame = new JFrame();
	JButton[][] button = new JButton[3][3];
	Container center = new Container();
	int winsX = 0;
	int winsO = 0;
	JLabel xname = new JLabel("X wins: " + winsX);
	JLabel oname = new JLabel("O wins: " + winsO);
	JButton xChangeName = new JButton("Change X's Name:");
	JButton oChangeName = new JButton("Change O's Name:");
	JTextField xChangeField = new JTextField();
	JTextField oChangeField = new JTextField();
	Container north = new Container();
	Font font = new Font("Arial", Font.PLAIN, 25);
	int[][] board = new int[3][3];
	final int BLANK = 0;
	final int X_MOVE = 1;		//used by the board
	final int O_MOVE = 2;		//used by the board
	final int X_TURN = 0; 		//used by the turn
	final int O_TURN = 1;		//used by the turn
	int turn = X_TURN;
	Color initial = xChangeName.getBackground();
	
	public GUITicTacToe() {
		frame.setSize(640, 640);
		//Center grid container
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(3,3));
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				button[j][i] = new JButton("");
				button[j][i].setFont(font);
				center.add(button[j][i]);
				button[j][i].addActionListener(this);
				
			}
		}
		frame.add(center, BorderLayout.CENTER);
		//North container
		north.setLayout(new GridLayout(3, 2));
		north.add(xname);
		north.add(oname);
		north.add(xChangeName);
		xChangeName.addActionListener(this);
		north.add(xChangeField);
		north.add(oChangeName);
		oChangeName.addActionListener(this);
		north.add(oChangeField);
		frame.add(north, BorderLayout.NORTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUITicTacToe();
		
	}

	public void actionPerformed(ActionEvent event) {
		JButton current;
		if (event.getSource().equals(xChangeName)) {
//			System.out.println(xChangeField.getText());
			String xName = xChangeField.getText();
			xname.setText(xName + " wins: " + winsX);
			xChangeName.setText("Change " + xName + " name:");
		} else if (event.getSource().equals(oChangeName)) {
//			System.out.println(oChangeField.getText());
			String oName = oChangeField.getText();
			oname.setText(oName + " wins: " + winsO);
			oChangeName.setText("Change " + oName + " name:");
		} else {
			for (int i = 0; i < button.length; i++) {
				for (int j = 0; j < button[0].length; j++) {
					if (event.getSource().equals(button[j][i])) {
						current = button[j][i];
	//					System.out.printf("Found button %d, %d\n", j, i);
						if (board[j][i] == BLANK) {
							if (turn == X_TURN) {
								current.setBackground(new Color(200,100, 100));
								current.setText("X");
								board[j][i] = X_MOVE;
								turn = O_TURN;
							} else {
								current.setBackground(new Color(100,100,200));
								current.setText("O");
								board[j][i] = O_MOVE;
								turn = X_TURN;
							}
							if (checkWin(X_MOVE) == true) {
								winsX++;
								updateBoard();
							
							} else if (checkWin(O_MOVE) == true) {
								winsO++;
								updateBoard();
							} else if (checkTie() == true) {
								updateBoard();
							}
						}
					} 
				}
			}
		}
	}

	public boolean checkWin(int player) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			} else if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			} 
		}
		return ((board[0][0] == player && board[1][1] == player && board[2][2] == player)||
				(board[0][2] == player && board[1][1] == player && board[2][0] == player));
	}
	
	public boolean checkTie() {
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column] == BLANK) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void updateBoard() {
		String xName = xChangeField.getText();
		String oName = oChangeField.getText();
		xname.setText(xName + " wins: " + winsX);
		oname.setText(oName + " wins: " + winsO);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[j][i] = BLANK;
				button[j][i].setText("");
				button[j][i].setBackground(initial);
			}
		}
	}
	
}
