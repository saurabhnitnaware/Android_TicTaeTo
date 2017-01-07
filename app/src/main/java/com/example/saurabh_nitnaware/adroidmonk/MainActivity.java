package com.example.saurabh_nitnaware.adroidmonk;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button b00;
    Button b01;
    Button b02;

    Button b10;
    Button b11;
    Button b12;

    Button b20;
    Button b21;
    Button b22;

    Button bReset;

    boolean PLAYER_X = true;
    int TURN_COUNT = 0;

    int boardStatus[][] = new int[3][3];

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeBoard();

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);

        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);

        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        bReset = (Button) findViewById(R.id.bReset);

        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        bReset.setOnClickListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }

        }
    }

        public void onClick (View view){

        int id = view.getId();

        switch (id){
            case R.id.b00 :

                if(PLAYER_X){
                    b00.setText("X");
                    boardStatus[0][0] = 1;
                }else{
                    b00.setText("O");
                    boardStatus[0][0] = 0;
                }

                b00.setEnabled(false);
                break;

            case R.id.b01 :

                if(PLAYER_X){
                    b01.setText("X");
                    boardStatus[0][1] = 1;
                }else{
                    b01.setText("O");
                    boardStatus[0][1] = 0;
                }

                b01.setEnabled(false);
                break;

            case R.id.b02 :

                if(PLAYER_X){
                    b02.setText("X");
                    boardStatus[0][2] = 1;
                }else{
                    b02.setText("O");
                    boardStatus[0][2] = 0;
                }

                b02.setEnabled(false);
                break;

            case R.id.b10 :

                if(PLAYER_X){
                    b10.setText("X");
                    boardStatus[1][0] = 1;
                }else{
                    b10.setText("O");
                    boardStatus[1][0] = 0;
                }

                b10.setEnabled(false);
                break;

            case R.id.b11 :
                if(PLAYER_X){
                    b11.setText("X");
                    boardStatus[1][1] = 1;
                }else{
                    b11.setText("O");
                    boardStatus[1][1] = 0;
                }

                b11.setEnabled(false);
                break;

            case R.id.b12 :
                if(PLAYER_X){
                    b12.setText("X");
                    boardStatus[1][2] = 1;
                }else{
                    b12.setText("O");
                    boardStatus[1][2] = 0;
                }

                b12.setEnabled(false);
                break;

            case R.id.b20 :
                if(PLAYER_X){
                    b20.setText("X");
                    boardStatus[2][0] = 1;
                }else{
                    b20.setText("O");
                    boardStatus[2][0] = 0;
                }

                b20.setEnabled(false);
                break;

            case R.id.b21 :
                if(PLAYER_X){
                    b21.setText("X");
                    boardStatus[2][1] = 1;
                }else{
                    b21.setText("O");
                    boardStatus[2][1] = 0;
                }

                b21.setEnabled(false);
                break;

            case R.id.b22 :
                if(PLAYER_X){
                    b22.setText("X");
                    boardStatus[2][2] = 1;
                }else{
                    b10.setText("O");
                    boardStatus[2][2] = 0;
                }

                b22.setEnabled(false);
                break;


            default:
                break;
        }

            if(id==R.id.bReset){

                initializeBoard();

                b00.setText("");
                b01.setText("");
                b02.setText("");
                b10.setText("");
                b11.setText("");
                b12.setText("");
                b20.setText("");
                b21.setText("");
                b22.setText("");

                b00.setEnabled(true);
                b01.setEnabled(true);
                b02.setEnabled(true);
                b10.setEnabled(true);
                b11.setEnabled(true);
                b12.setEnabled(true);
                b20.setEnabled(true);
                b21.setEnabled(true);
                b22.setEnabled(true);
            }else{
                TURN_COUNT++;
                PLAYER_X=!PLAYER_X;
                if(checkWinner() == 1){
                    Toast.makeText(getApplicationContext(),"Player 1 wins",Toast.LENGTH_LONG).show();
                }
                else if(checkWinner()== 0){
                    Toast.makeText(getApplicationContext(),"Player 2 wins",Toast.LENGTH_LONG)
                            .show();
                }
                else if (TURN_COUNT==9)
                {
                    Toast.makeText(getApplicationContext(),"Draw",Toast.LENGTH_LONG).show();
                }
            }



        }

    private int checkWinner(){
        for(int i=0;i<3;i++){
            if(boardStatus[i][0] != -1 && boardStatus[i][0] == boardStatus[i][1] &&
                    boardStatus[i][0] == boardStatus[i][2]){
                return boardStatus[i][0];
            }
            if(boardStatus[0][i] != -1 && boardStatus[0][i] == boardStatus[1][i] &&
                    boardStatus[0][i] == boardStatus[2][i]){
                return boardStatus[0][i];
            }

        }
        if(boardStatus[0][0] != -1 && boardStatus[0][0] == boardStatus[1][1] &&
                boardStatus[1][1] == boardStatus[2][2] ){
            return boardStatus[0][0];
        }

        if(boardStatus[0][2] != -1 && boardStatus[0][2] == boardStatus[1][1] &&
                boardStatus[1][1] == boardStatus[2][0] ){
            return boardStatus[0][2];
        }
        return -1;
    }

    }
/*
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.saurabh_nitnaware.adroidmonk/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.saurabh_nitnaware.adroidmonk/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    */


