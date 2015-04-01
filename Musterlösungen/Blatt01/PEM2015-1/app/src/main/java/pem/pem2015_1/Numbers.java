package pem.pem2015_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Numbers extends ActionBarActivity {
    EditText input;
    TextView feedback;
    Button guessButton;
    Button restartButton;
    GameLogic gameLogic;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        input =   (EditText) findViewById(R.id.input);
        feedback= (TextView) findViewById(R.id.feedback);
        guessButton= (Button) findViewById(R.id.guessButton);
        restartButton=(Button) findViewById(R.id.restartButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        //imageView.setImageResource(R.drawable.zahlenraten);

        gameLogic=new GameLogic();
        gameLogic.setRandomNumber();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_numbers, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void guessNumber(View view){
        if(input.getText().toString().contentEquals("")) {
            Toast.makeText(this.getApplicationContext(),"Please type a number in the field before pressing guess!",Toast.LENGTH_SHORT).show();

            return;
        }
        int guess = Integer.parseInt(input.getText().toString());
        switch(gameLogic.handleGuess(guess)){
            case 2: feedback.setText("You didn't guess my number in 5 Tries, you can play again by tapping Restart Game");
                    imageView.setImageResource(R.drawable.loose);
                    break;
            case -1: feedback.setText("My number is higher than your guess!");
                    imageView.setImageResource(R.drawable.higher);
                     break;
            case 0:  feedback.setText("Congratulations you guessed my number you can play again by tapping Restart Game");
                    imageView.setImageResource(R.drawable.success);
                     break;
            case 1:  feedback.setText("My number is lower than your guess!");
                    imageView.setImageResource(R.drawable.lower);
                     break;
        }
    }

    public void restartGame(View view){
        gameLogic.handleRestart();
        imageView.setImageResource(R.drawable.zahlenraten);
        feedback.setText(R.string.startFeedback);
        input.setText("");
    }
}
