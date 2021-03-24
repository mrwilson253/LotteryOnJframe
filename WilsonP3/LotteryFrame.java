/*
*Jordan Wilson - jwilson160@cnm.edu
*WilsonP3 - Lottery on JFrame
*LotterFrame
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.text.*;

public class LotteryFrame extends JFrame{
	private Lottery lotto;
	
	//variables
	private JTextField jtfGuess;
	private JTextField jtfLottery;
	private JTextField jtfResults;
	private JTextField jtfWinnings;
	private JTextField jtfRounds;
	
	private JButton jbtPlay;
	private JButton jbtPlayAgain;
	private JButton jbtDone;
	
	//frame default
	public LotteryFrame(){}
	
	//frame
	public LotteryFrame(Lottery lot){
		//class
		lotto = lot;
		//initialize
		initComponents(); 
		//button events
		jbtPlay.addActionListener(new PlayListener());
		jbtPlayAgain.addActionListener(new PlayAgainListener());
		jbtDone.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				MyAnonymousButton();
			}
		});
	}
	
	private void initComponents(){
		jtfGuess = new JTextField();
		jtfLottery = new JTextField();
		jtfResults = new JTextField();
		jtfWinnings = new JTextField();
		jtfRounds = new JTextField();
		jbtPlay = new JButton("Play");
		jbtPlayAgain = new JButton("Play Again");
		jbtDone = new JButton("Done");
		//hide play again at start
		jbtPlayAgain.setVisible(false);
		//panels
		JPanel p1 = new JPanel(new GridLayout(5,2));
		p1.add(new JLabel("Guess"));
		p1.add(jtfGuess);
		p1.add(new JLabel("Lottery Number"));
		p1.add(jtfLottery);
		p1.add(new JLabel("Results"));
		p1.add(jtfResults);
		p1.add(new JLabel("Winnings"));
		p1.add(jtfWinnings);
		p1.add(new JLabel("Rounds Played"));
		p1.add(jtfRounds);
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p2.add(jbtPlay);
		p2.add(jbtPlayAgain);
		p2.add(jbtDone);
		
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
	}
	
	private class PlayListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
				String guess = jtfGuess.getText();
				
				lotto.setUserGuess(guess);
				
				jtfLottery.setText(Integer.toString(lotto.getLottery()));
				jtfResults.setText(lotto.getResult());
				jtfWinnings.setText(Integer.toString(lotto.getWinnings()));
				jtfRounds.setText(Integer.toString(lotto.getNumGames()));
				
				jbtPlay.setVisible(false);
				jbtPlayAgain.setVisible(true);
		}
	}
	
	private class PlayAgainListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			jtfGuess.setText(null);
			jtfLottery.setText(null);
			jtfResults.setText(null);
			
			jbtPlayAgain.setVisible(false);
			jbtPlay.setVisible(true);
		}
	}

	private void MyAnonymousButton(){
		String end = "You won $"+lotto.getWinnings()+" after "+lotto.getNumGames()+" rounds!\nThanks for playing!";
		JOptionPane.showMessageDialog(null, end, "Good-bye", JOptionPane.PLAIN_MESSAGE);
			
		System.exit(0);
	}
	
	
	
	

}