import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel implements ActionListener{
	//setup window
	JFrame frame = new JFrame("Yahtzee");
	//setup buttons
	JButton roll = new JButton("Roll");
	JButton keep = new JButton("Keep Selected Dice");
	JButton done = new JButton("Done with the turn!");
		//JButton howToB = new JButton("How to Score?");
	//setup containers
	Container buttons = new Container();
	Container scoreSheet = new Container();
	Container north = new Container();
	Container east = new Container();
	//setup text labels
	JLabel highS = new JLabel("High Score");
	JLabel upper = new JLabel("Upper Section");
	JLabel upperE = new JLabel("");
	JLabel aces = new JLabel("Aces = 1");
	JLabel twos = new JLabel("Twos = 2");
	JLabel threes = new JLabel("Threes = 3");
	JLabel fours = new JLabel("Fours = 4");
	JLabel fives = new JLabel("Fives = 5");
	JLabel sixes = new JLabel("Sixes = 6");
	JLabel total = new JLabel("TOTAL");
	JLabel bonus = new JLabel("BONUS");
	JLabel totalU = new JLabel("TOTAL UPPER");
	JLabel lowerS = new JLabel("Lower Section");
	JLabel lowerE = new JLabel("");
	JLabel sOne = new JLabel("");
	JLabel sTwo = new JLabel("");
	JLabel kindT = new JLabel("3 of a Kind");
	JLabel kindF = new JLabel("4 of a Kind");
	JLabel houseF = new JLabel("Full House");
	JLabel houseS = new JLabel("Sm. House");
	JLabel houseL = new JLabel("Lg. House");
	JLabel yah = new JLabel("Yahtzee");
	JLabel chance = new JLabel("Chance");
	JLabel yahBonus = new JLabel("Yahtzee Bonus");
	JLabel totU = new JLabel("Total of Upper");
	JLabel totalL = new JLabel("Total of Lower");
	JLabel totalT = new JLabel("TOTAL TOTAL");
	
	JLabel Total = new JLabel("");
	JLabel TotalU = new JLabel("");
	JLabel TotU = new JLabel("");
	JLabel TotalL = new JLabel("");
	JLabel TotalT = new JLabel("");
	
	JLabel keep1 = new JLabel("This is how the dice are organized:");
	JLabel keep2 = new JLabel("    1   2   3");
	JLabel keep3 = new JLabel("      4   5");
	JLabel keep4 = new JLabel("Write which dice you want to keep (ex: 123): ");
	JLabel turn = new JLabel("You have not rolled yet.");
	//setup scoring buttons (they were TF initially, ignore the naming)
	JButton aceTF = new JButton("0");
	JButton twoTF = new JButton("0");
	JButton threeTF = new JButton("0");
	JButton fourTF = new JButton("0");
	JButton fiveTF = new JButton("0");
	JButton sixTF = new JButton("0");
	JButton bonusTF = new JButton("0");
	JButton TkindTF = new JButton("0");
	JButton FkindTF = new JButton("0");
	JButton FhouseTF = new JButton("0");
	JButton ShouseTF = new JButton("0");
	JButton LhouseTF = new JButton("0");
	JButton yahTF = new JButton("0");
	JButton chanceTF = new JButton("0");
	JButton yahBonusTF = new JButton("0");
	//setup keep TextField
	JTextField keepTF = new JTextField();
	//setup dice array list
	ArrayList<Dice> dice = new ArrayList<Dice>();
	//setup variables
	int highscore = 0;
	int turns = 0;
	int t = 0;
	int tu = 0;
	int tl = 0;
	int T = 0;
	int[][] temp = new int[5][4];
	int[][] fi = new int[5][3];
	int cha = 0;
	
	String in;
	ArrayList<Integer> keepA = new ArrayList<Integer>();
	int[] score = new int[13];
	int[][] comp = new int[5][3];
	boolean[] clicked = new boolean[13];
	
			
	public MainPanel() {
		//set window layout
		frame.setSize(850,500);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buttons.setLayout(new GridLayout(3,1));
		buttons.add(roll);
		roll.addActionListener(this);
		roll.setEnabled(true);
		buttons.add(keep);
		keep.addActionListener(this);
		keep.setEnabled(false);
		buttons.add(done);
		done.addActionListener(this);
		done.setEnabled(false);
		//buttons.add(howToB);
		//howToB.addActionListener(this);
		frame.add(buttons, BorderLayout.SOUTH);
		
		
		scoreSheet.setLayout(new GridLayout(23,2));
		//add the labels and textfields to the score sheet
		scoreSheet.add(upper);
		scoreSheet.add(upperE);
		scoreSheet.add(aces);
		scoreSheet.add(aceTF);
		aceTF.addActionListener(this);
		scoreSheet.add(twos);
		scoreSheet.add(twoTF);
		twoTF.addActionListener(this);
		scoreSheet.add(threes);
		scoreSheet.add(threeTF);
		threeTF.addActionListener(this);
		scoreSheet.add(fours);
		scoreSheet.add(fourTF);
		fourTF.addActionListener(this);
		scoreSheet.add(fives);
		scoreSheet.add(fiveTF);
		fiveTF.addActionListener(this);
		scoreSheet.add(sixes);
		scoreSheet.add(sixTF);
		sixTF.addActionListener(this);
		scoreSheet.add(total);
		Total.setText("" + t);
		scoreSheet.add(Total);
		scoreSheet.add(bonus);
		scoreSheet.add(bonusTF);
		bonusTF.addActionListener(this);
		scoreSheet.add(totalU);
		TotalU.setText("" + tu);
		scoreSheet.add(TotalU);
		scoreSheet.add(sOne);
		scoreSheet.add(sTwo);
		scoreSheet.add(lowerS);
		scoreSheet.add(lowerE);
		scoreSheet.add(kindT);
		scoreSheet.add(TkindTF);
		TkindTF.addActionListener(this);
		scoreSheet.add(kindF);
		scoreSheet.add(FkindTF);
		FkindTF.addActionListener(this);
		scoreSheet.add(houseF);
		scoreSheet.add(FhouseTF);
		FhouseTF.addActionListener(this);
		scoreSheet.add(houseS);
		scoreSheet.add(ShouseTF);
		ShouseTF.addActionListener(this);
		scoreSheet.add(houseL);
		scoreSheet.add(LhouseTF);
		LhouseTF.addActionListener(this);
		scoreSheet.add(yah);
		scoreSheet.add(yahTF);
		yahTF.addActionListener(this);
		scoreSheet.add(chance);
		scoreSheet.add(chanceTF);
		chanceTF.addActionListener(this);
		scoreSheet.add(yahBonus);
		scoreSheet.add(yahBonusTF);
		yahBonusTF.addActionListener(this);
		scoreSheet.add(totU);
		TotU.setText("" + tu);
		scoreSheet.add(TotU);
		scoreSheet.add(totalL);
		TotalL.setText("" + tl);
		scoreSheet.add(TotalL);
		scoreSheet.add(totalT);
		TotalT.setText("" + T);
		scoreSheet.add(TotalT);
		
		
		
		frame.add(scoreSheet, BorderLayout.WEST);
		
		east.setLayout(new GridLayout(5, 1));
		east.add(keep1);
		east.add(keep2);
		east.add(keep3);
		east.add(keep4);
		east.add(keepTF);
		frame.add(east, BorderLayout.EAST);
		
		north.setLayout(new GridLayout(2,2));
		north.add(highS);
		//none clicked yet
		for (int i = 0; i < clicked.length; i++) {
			clicked[i] = false;
		}
		//get high score from file and put it into int 'highscore'
		try {
			Scanner scanner = new Scanner(new File("highscore.txt"));
			in = scanner.nextLine();
			String[] read = in.split(",");
			ArrayList<Integer> inp = new ArrayList<Integer>();
			for (int i = 0; i < read.length; i++) {
				inp.add(Integer.parseInt(read[i]));
			}
			int max = inp.get(0);
			for (int i = 0; i < inp.size(); i++) {
				if(max < inp.get(i)) {
					max = inp.get(i);
				}
			}
			scanner.close();
			if (in != null) {
				highscore = max;
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		highS.setText("High Score: " + highscore);
		north.add(highS);
		turn.setText("You have not rolled yet.");
		north.add(turn);
		frame.add(north, BorderLayout.NORTH);
		
		for (int i = 0; i < fi.length; i++) {
			for (int j = 0; j < fi[0].length; j++) {
				fi[i][j] = 0;
			}
		}
		
		Dice d;
		d = new Dice(100, 100);
		dice.add(d);
		d = new Dice(200, 100);
		dice.add(d);
		d = new Dice(300, 100);
		dice.add(d);
		d = new Dice(150, 200);
		dice.add(d);
		d = new Dice(250, 200);
		dice.add(d);
		
		for (int i = 0; i < 5; i++) {
			temp[i][0] =((int)(Math.random() * 6) + 1);
			dice.get(i).setImage(temp[i][0]);
			
		}
		
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(roll)) {
			Roll();
			keep.setEnabled(true);
			done.setEnabled(true);
			if(turns >= 3) {
				roll.setEnabled(false);
			}
			
			
		}
		if(event.getSource().equals(keep)) {
			try {
				if(turns == 1) {
					String f = keepTF.getText();
					for (int i = 0; i < f.length(); i++) {
						int l = Integer.parseInt(Character.toString(f.charAt(i)));
						fi[l-1][0] = temp[l-1][1];
					}
				} else if (turns == 2){
					String f = keepTF.getText();
					for (int i = 0; i < f.length(); i++) {
						int l = Integer.parseInt(Character.toString(f.charAt(i)));
						if( fi[l-1][0] != 0) {
							fi[l-1][1] = fi[l-1][0];
						} else {
							fi[l-1][1] = temp[l-1][2];
						}
					}
				} else if (turns == 3){
					String f = keepTF.getText();
					for (int i = 0; i < f.length(); i++) {
						int l = Integer.parseInt(Character.toString(f.charAt(i)));
							if( fi[l-1][1] != 0) {
								fi[l-1][2] = fi[l-1][1];
							} else {
								fi[l-1][2] = temp[l-1][2];
							}
					}
				}
			} catch(NumberFormatException ex) {
				System.out.println("Input is not an int value"); 
				// Here catch NumberFormatException
				// So input is not a int.
			} 
		
		}
		if(event.getSource().equals(done)) {
			//begin scoring process
			cha = 0;
			int[] numCount = new int[6];
			for (int j = 0; j < comp.length; j++) {
				for (int i = 0; i < numCount.length; i++) {
					if(comp[j][turns-1] == i+1) {
						numCount[i]++;
					}
				}
			}
			//lower scoring
			for (int i = 0; i < numCount.length; i++) {
				if(clicked[12] == false) {
					if (numCount[i] >= 1) {
						//chance
						cha += numCount[i]*(i+1);
					}
					chanceTF.setText(Integer.toString(cha));
				}
				
				
				if(numCount[i] == 5) {
					//yahtzee!
					if(clicked[11] == false) {
						yahTF.setText("50");
					} else {
						//yahtzee bonus
						yahTF.setText(Integer.toString(Integer.parseInt(yahTF.getText())+100));
						yahBonusTF.setText(Integer.toString(Integer.parseInt(yahBonusTF.getText())+100));
					}
				}
				if(numCount[i] == 3) {
					if(clicked[6] == false) {
						//three of a kind
						TkindTF.setText(Integer.toString((i+1)*3));
					}
				}
				if(numCount[i] == 4) {
					if(clicked[7] == false) {
						//four of a kind
						FkindTF.setText(Integer.toString((i+1)*4));
					}
				}
				if(clicked[8] == false) {
					for (int j = 0; j < numCount.length; j++) {
						if(numCount[i] == 2 && numCount[j] == 3 && i != j) {
							//full house (a triplet and a pair)
							FhouseTF.setText("25");
						}
					}
				}	
			}
			if(clicked[9] == false) {
				if(numCount[0] >= 1 && numCount[1] >= 1 && numCount[2] >= 1 && numCount[3] >= 1 ||
						numCount[1] >= 1 && numCount[2] >= 1 && numCount[3] >= 1 && numCount[4] >= 1 ||
						numCount[2] >= 1 && numCount[3] >= 1 && numCount[4] >= 1 && numCount[5] >= 1) {
					//small house (four in a row)
					ShouseTF.setText("30");
				}
			}
			if(clicked[10] == false) {
				if(numCount[0] >= 1 && numCount[1] >= 1 && numCount[2] >= 1 && numCount[3] >= 1 && numCount[4] >= 1 ||
						numCount[1] >= 1 && numCount[2] >= 1 && numCount[3] >= 1 && numCount[4] >= 1 && numCount[5] >= 1) {
					//large house (five in a row)
					LhouseTF.setText("40");
				}
			}
			
			//upper scoring
			roll.setEnabled(false);
			keep.setEnabled(false);
			for (int i = 0; i < comp.length; i++) {
				if(comp[i][turns-1] == 1 && clicked[0] == false) {
					aceTF.setText(Integer.toString(Integer.parseInt(aceTF.getText()) + comp[i][turns-1]));
					aceTF.setEnabled(true);
				}
				if(comp[i][turns-1] == 2 && clicked[1] == false) {
					twoTF.setText(Integer.toString(Integer.parseInt(twoTF.getText()) + comp[i][turns-1]));
					twoTF.setEnabled(true);
				} 
				if(comp[i][turns-1] == 3 && clicked[2] == false) {
					threeTF.setText(Integer.toString(Integer.parseInt(threeTF.getText()) + comp[i][turns-1]));
					threeTF.setEnabled(true);
				} 
				if(comp[i][turns-1] == 4 && clicked[3] == false) {
					fourTF.setText(Integer.toString(Integer.parseInt(fourTF.getText()) + comp[i][turns-1]));
					fourTF.setEnabled(true);
				} 
				if(comp[i][turns-1] == 5 && clicked[4] == false) {
					fiveTF.setText(Integer.toString(Integer.parseInt(fiveTF.getText()) + comp[i][turns-1]));
					fiveTF.setEnabled(true);
				} 
				if(comp[i][turns-1] == 6 && clicked[5] == false) {
					sixTF.setText(Integer.toString(Integer.parseInt(sixTF.getText()) + comp[i][turns-1]));
					sixTF.setEnabled(true);
				}
			}
			
		}
		
		if(event.getSource().equals(aceTF)) {
			score[0] = Integer.parseInt(aceTF.getText());
			tu += score[0];
			clicked[0] = true;
			Clean();
			aceTF.setEnabled(false);	
		}
		if(event.getSource().equals(twoTF)) {
			score[1] = Integer.parseInt(twoTF.getText());
			tu += score[1];
			clicked[1] = true;
			Clean();
			twoTF.setEnabled(false);
		}
		if(event.getSource().equals(threeTF)) {
			score[2] = Integer.parseInt(threeTF.getText());
			tu += score[2];
			clicked[2] = true;
			Clean();
			threeTF.setEnabled(false);
		}
		if(event.getSource().equals(fourTF)) {
			score[3] = Integer.parseInt(fourTF.getText());
			tu += score[3];
			clicked[3] = true;
			Clean();
			fourTF.setEnabled(false);
		}
		if(event.getSource().equals(fiveTF)) {
			score[4] = Integer.parseInt(fiveTF.getText());
			tu += score[4];
			clicked[4] = true;
			Clean();
			fiveTF.setEnabled(false);
		}
		if(event.getSource().equals(sixTF)) {
			score[5] = Integer.parseInt(sixTF.getText());
			tu += score[5];
			clicked[5] = true;
			Clean();
			sixTF.setEnabled(false);
		}
		if(event.getSource().equals(TkindTF)) {
			score[6] = Integer.parseInt(TkindTF.getText());
			tl += score[6];
			clicked[6] = true;
			Clean();
			TkindTF.setEnabled(false);
		}
		if(event.getSource().equals(FkindTF)) {
			score[7] = Integer.parseInt(FkindTF.getText());
			tl += score[7];
			clicked[7] = true;
			Clean();
			FkindTF.setEnabled(false);
		}
		if(event.getSource().equals(FhouseTF)) {
			score[8] = Integer.parseInt(FhouseTF.getText());
			tl += score[8];
			clicked[8] = true;
			Clean();
			FhouseTF.setEnabled(false);
		}
		if(event.getSource().equals(ShouseTF)) {
			score[9] = Integer.parseInt(ShouseTF.getText());
			tl += score[9];
			clicked[9] = true;
			Clean();
			ShouseTF.setEnabled(false);
		}
		if(event.getSource().equals(LhouseTF)) {
			score[10] = Integer.parseInt(LhouseTF.getText());
			tl += score[10];
			clicked[10] = true;
			Clean();
			LhouseTF.setEnabled(false);
		}
		if(event.getSource().equals(yahTF)) {
			score[11] = Integer.parseInt(yahTF.getText());
			tl += score[11];
			clicked[11] = true;
			Clean();
			yahTF.setEnabled(false);
		}
		if(event.getSource().equals(chanceTF)) {
			score[12] = Integer.parseInt(chanceTF.getText());
			tl += score[12];
			clicked[12] = true;
			Clean();
			chanceTF.setEnabled(false);
		}
		
	}
	
	private void Clean() {
		keepTF.setText("");
		turns = 0;
		for (int i = 0; i < fi.length; i++) {
			for (int j = 0; j < fi[0].length; j++) {
				fi[i][j] =0;
			}
		}
		roll.setEnabled(true);
		keep.setEnabled(false);
		if(clicked[0] == false) {
			aceTF.setText("0");
		}
		if(clicked[1] == false) {
			twoTF.setText("0");
		}
		if(clicked[2] == false) {
			threeTF.setText("0");
		} 
		if(clicked[3] == false) {
			fourTF.setText("0");
		} 
		if(clicked[4] == false) {
			fiveTF.setText("0");
		} 
		if(clicked[5] == false) {
			sixTF.setText("0");
		}
		if(clicked[6] == false) {
			TkindTF.setText("0");
		}
		if(clicked[7] == false) {
			FkindTF.setText("0");
		}
		if(clicked[8] == false) {
			FhouseTF.setText("0");
		}
		if(clicked[9] == false) {
			ShouseTF.setText("0");
		}
		if(clicked[10] == false) {
			LhouseTF.setText("0");
		}
		if(clicked[11] == false) {
			yahTF.setText("0");
		}
		if(clicked[12] == false) {
			chanceTF.setText("0");
		}
		//upper bonus
		if(clicked[0] == true && clicked[1] == true && clicked[2] == true && clicked[3] == true && clicked[4] == true && clicked[5] == true) {
			Total.setText("" + tu);
			if (tu >= 63) {
				bonusTF.setText("35");
				tu += 35;
				TotalU.setText("" + tu);
				TotU.setText("" + tu);
				bonusTF.setEnabled(false);
			} else {
				bonusTF.setText("0");
				bonusTF.setEnabled(false);
			}
		}
		
		//finished game
		if(clicked[0] == true && clicked[1] == true && clicked[2] == true && clicked[3] == true && clicked[4] == true && clicked[5] == true && 
				clicked[6] == true && clicked[7] == true && clicked[8] == true && clicked[9] == true && clicked[10] == true && clicked[11] == true && clicked[12] == true) {
			T = tu + tl;
			TotalL.setText("" + tl);
			TotalT.setText("" + T);
			JOptionPane.showMessageDialog(frame, "You have finished the game. Your grand total was " + T + " points.\n"
					+ "This will be added to the highscores file.\n"
					+ "To start a new game, please restart the program...");
			roll.setEnabled(false);
			//put in total to file "highscore.txt"
			BufferedWriter bw = null;
			FileWriter fw = null;
			File file = new File("highscore.txt");
			try {
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				bw.write(Integer.toString(T) + ",");
				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}

	public void Roll() {
		turns = turns + 1;
		for (int i = 0; i < 5; i++) {
			if(turns >= 2) {
				if(fi[i][turns-2] == 0) {
					temp[i][turns] =((int)(Math.random() * 6)+1);
					dice.get(i).setImage(temp[i][turns]);
					comp[i][turns-1] = temp[i][turns];
				} else {
					dice.get(i).setImage(fi[i][turns-2]);
					comp[i][turns-1] = fi[i][turns-2];
				}
			} else {
				temp[i][turns] =((int)(Math.random() * 6)+1);
				dice.get(i).setImage(temp[i][turns]);
				comp[i][turns-1] = temp[i][turns];
			}
		}

		turn.setText("You are at roll number " + turns);
		
		frame.repaint();
		return;
	}
	
	public void paintComponent(Graphics g) {
		for (int i = 0; i < temp.length; i++) {
			dice.get(i).paintMe(g);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new MainPanel();

	}

}
