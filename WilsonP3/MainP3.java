/*
*Jordan Wilson - jwilson160@cnm.edu
*WilsonP3 - Lottery on JFrame
*MainP3
*/

import javax.swing.*;

public class MainP3{
	public static void main(String[] args){
		Lottery lotto = new Lottery();
		LotteryFrame frame = new LotteryFrame(lotto);
		frame.setTitle("Jordan Wilson, Lottery, Program 3");
		frame.setSize(430,450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}