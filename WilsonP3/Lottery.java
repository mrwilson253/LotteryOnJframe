/*
*Jordan Wilson - jwilson160@cnm.edu
*WilsonP3 - Lottery on JFrame
*Lottery
*/

public class Lottery {

    //instance variables
    private int numGames = 0;
    private int winnings = 0;
    private int lottNum;    //random number
    private int guess;      //user guess
    private int lotteryDigit1;
    private int lotteryDigit2;
    private int lotteryDigit3;
    private int guessDigit1;
    private int guessDigit2;
    private int guessDigit3;
    private String result;

    public Lottery(){
    }

    public void setUserGuess(String newGuess){
        //convert String into an int
        guess = Integer.parseInt(newGuess);

        //get the lottery number
        lottNum = 100 + (int) (Math.random() * (1000-100));

        //check guess
        checkGuess();

        //increment the number of games played
        numGames++;
    }

    private void checkGuess(){
        seperateDigits();

        //figure out how much the user won
        //assign a message to the result variable
        //dont forget to increment winnings
        //variables to track matching numbers
        int match = 0;
        int exact = 0;
        int[] guessArray = new int[]{guessDigit1, guessDigit2, guessDigit3};
        int[] lotteryArray = new int[]{lotteryDigit1, lotteryDigit2, lotteryDigit3};

        /*
        outter loop holds a lottery digit that is compared to each guess digit on the innner loop
        once all guess digits have been compared, the outter loop moves to the next lottery digit
        and repeats comparison. This method does award the player for matching one of their guess digits
        to to a recurring lottery digit for a maximum award of 3,000.
         */
        for (int i = 0; i < 3; ++i) {
            int lotTemp = lotteryArray[i];
            for (int j = 0; j < 3; ++j) {
                int guessTemp = guessArray[j];
                if (lotTemp == guessTemp) {
                    if (i == j) {
                        exact++;
                        match++;
                    } else {
                        match++;
                    }
                }
            }
        }

        //calculating winnings based on matching digits
        if (exact == 3) {
            result = "Exact match! You win $10,000.";
            winnings+=10000;
        } else if (match == 3 && exact != 3) {
            result = "Match all digits! You win $3,000.";
            winnings+=3000;
        } else if (match == 1 || match == 2) {
            result = "Match one digit! You win $1,000.";
            winnings+=1000;
        } else {
            result = "Sorry! No match.";
        }
    }

    private void seperateDigits(){
        //seperate digits for lottery and user guess
        lotteryDigit1 = lottNum/100;
        lotteryDigit2 = (lottNum%100)/10;
        lotteryDigit3 = lottNum%10;

        guessDigit1 = guess/100;
        guessDigit2 = (guess%100)/10;
        guessDigit3 = guess%10;
    }

    public int getLottery(){ return lottNum; }

    public String getResult(){
        return result;
    }

    public int getNumGames(){
        return numGames;
    }

    public int getWinnings(){
        return winnings;
    }
}