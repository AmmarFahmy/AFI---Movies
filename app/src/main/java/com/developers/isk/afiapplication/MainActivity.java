package com.developers.isk.afiapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView firstMovie,secondMovie,thirdMovie,fourthMovie,fifthMovie;
    private Button findButton;
    int randomValue = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstMovie = (TextView) findViewById(R.id.firstMovie);
        secondMovie = (TextView) findViewById(R.id.secondMovie);
        thirdMovie = (TextView) findViewById(R.id.thirdMovie);
        fourthMovie = (TextView) findViewById(R.id.fourthMovie);
        fifthMovie = (TextView) findViewById(R.id.fifthMovie);

        firstMovie.setTypeface(null,Typeface.BOLD);
        secondMovie.setTypeface(null,Typeface.BOLD);
        thirdMovie.setTypeface(null,Typeface.BOLD);
        fourthMovie.setTypeface(null,Typeface.BOLD);
        fifthMovie.setTypeface(null,Typeface.BOLD);



        findButton = (Button) findViewById(R.id.findButton);

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRandomMovies();
                displayToast();
            }
        });

        firstMovie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public void getRandomMovies(){
        Random randomVal = new Random();

        AFIMovies ml = new AFIMovies();
        String movieList[] = ml.movieList();

         randomValue = randomVal.nextInt(100)+1;
            firstMovie.setText("1) "+movieList[randomValue]);

         randomValue = randomVal.nextInt(100)+1;
            secondMovie.setText("2) "+movieList[randomValue]);

         randomValue = randomVal.nextInt(100)+1;
            thirdMovie.setText("3) "+movieList[randomValue]);

         randomValue = randomVal.nextInt(100)+1;
            fourthMovie.setText("4) "+movieList[randomValue]);

         randomValue = randomVal.nextInt(100)+1;
            fifthMovie.setText("5) "+movieList[randomValue]);
    }

    public void getTextValue(View v){
        String text = null;
        if(v instanceof TextView) {
            TextView t = (TextView) v;
            text = t.getText().toString();

        }
        Search("YouTube " + text);

    }

    public void Search(String keyword){
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, keyword);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void displayToast(){
        Toast.makeText(MainActivity.this,"Click on the text for YouTube videos",Toast.LENGTH_SHORT).show();
    }
}
