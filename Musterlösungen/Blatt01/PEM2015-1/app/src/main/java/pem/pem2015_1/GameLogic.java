package pem.pem2015_1;

import android.util.Log;

import java.util.Random;

/**
 * Created by Raphael on 23.03.2015.
 */
public class GameLogic {
    private int number;
    private int tries=0;

    public void setRandomNumber(){
        final Random r = new Random();
        number= r.nextInt(100)+1;
    }

    public int handleGuess(int guessedNumber){
        System.out.println("number= "+ number);
        tries++;
        if(tries>5) return 2;
        if(guessedNumber==number){
            return 0;
        }
        else if(guessedNumber>number){
            return 1;
        }
        else return -1;
    }

    public void handleRestart(){
        setRandomNumber();
        tries=0;
    }



}
