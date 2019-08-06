import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main implements ActionListener {
	
	JFrame frame = new JFrame("Chess");
	JButton[][] button = new JButton[8][8];
	Container center = new Container();
	Font font = new Font("Arial", Font.PLAIN, 25);
	int[][] board = new int[8][8];
	final int BLANK = 0;
	String blank = "";
	final int PAWN = 1;
	String p = "pawn";
	final int KING = 2;
	String k = "king";
	final int QUEEN = 3;
	String q = "queen";
	final int ROOK = 4;
	String r = "rook";
	final int HORSE = 5;
	String h = "horse";
	final int BISHOP = 6;
	String b = "bishop";
	boolean isTurn = false;
	int[] temp = new int[2];

	public Main() {
		frame.setSize(800, 800);
		frame.setLayout(new BorderLayout());
		//Center container
		center.setLayout(new GridLayout(8, 8));
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				button[j][i] = new JButton("");
				button[j][i].setForeground(new Color(255, 100, 100));
				center.add(button[j][i]);
				button[j][i].addActionListener(this);
				//Set button colors
				if(j % 2 == 0 && i % 2 ==0) {
					///white
					button[j][i].setBackground(new Color(255, 255, 255));
				} else if(j % 2 != 0 && i % 2 !=0) {
					///white
					button[j][i].setBackground(new Color(255, 255, 255));
				} else {
					//black
					///white
					button[j][i].setBackground(new Color(70, 70, 70));
				}
			}
		}
		frame.add(center, BorderLayout.CENTER);
		//initial pieces arrangement
		for (int row = 0; row < board.length; row++) {
			board[row][1] = PAWN;
			board[row][6] = PAWN;
		}
		board[0][0] = ROOK;
		board[0][7] = ROOK;
		board[7][0] = ROOK;
		board[7][7] = ROOK;
		board[1][0] = HORSE;
		board[6][0] = HORSE;
		board[1][7] = HORSE;
		board[6][7] = HORSE;
		board[2][0] = BISHOP;
		board[5][0] = BISHOP;
		board[2][7] = BISHOP;
		board[5][7] = BISHOP;
		board[3][0] = QUEEN;
		board[3][7] = QUEEN;
		board[4][0] = KING;
		board[4][7] = KING;
		doBoard();
		//Frame visibility
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}


	public void actionPerformed(ActionEvent event) {
		JButton current;
		if(isTurn == false) {
			for (int i = 0; i < button.length; i++) {
				for (int j = 0; j < button[0].length; j++) {
					if(event.getSource().equals(button[j][i])) {
						current = button[j][i];
						if(!button[j][i].getText().equals(blank)) {
							temp[0] = j;
							temp[1] = i;
							isTurn = true;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < button.length; i++) {
				for (int j = 0; j < button[0].length; j++) {
					if(event.getSource().equals(button[j][i])) {
						if(button[j][i].getText().equals(blank)) {
							current = button[j][i];
							current.setText(button[temp[0]][temp[1]].getText());
							button[temp[0]][temp[1]].setText(blank);
						}
						isTurn = false;
					}
				}
			}
		}
		
	}
	
	public void doBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[j][i] == BLANK) {
					button[j][i].setText(blank);
				} else if(board[j][i] == PAWN) {
					button[j][i].setText(p);
				} else if(board[j][i] == KING) {
					button[j][i].setText(k);
				} else if(board[j][i] == QUEEN) {
					button[j][i].setText(q);
				} else if(board[j][i] == ROOK) {
					button[j][i].setText(r);
				} else if(board[j][i] == HORSE) {
					button[j][i].setText(h);
				} else if(board[j][i] == BISHOP) {
					button[j][i].setText(b);
				}
			}
		}
	}

}
