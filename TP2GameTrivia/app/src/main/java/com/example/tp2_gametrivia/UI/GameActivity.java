package com.example.tp2_gametrivia.UI;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tp2_gametrivia.Database.AppDatabase;
import com.example.tp2_gametrivia.Entidades.Game;
import com.example.tp2_gametrivia.Entidades.Player;
import com.example.tp2_gametrivia.Interfaces.GameDao;
import com.example.tp2_gametrivia.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

import androidx.room.Room;

public class GameActivity extends Activity {
    private GameDao gameDao;
    ArrayList<String[]> questions = new ArrayList<String[]>();
    private TextView question;
    private TextView timer;
    private TextView score;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private int gameNumber = 0;
    private String answer;
    int timeValue = 30;
    int correctAns;
    CountDownTimer countDownTimer;
    GameDao db;
    AppDatabase dataBase;

    private JSONArray trivias;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        dataBase = Room.databaseBuilder(this, AppDatabase.class, "trivia.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.gameDao();

        player = (Player) getIntent().getSerializableExtra("Player");

        question = findViewById(R.id.gameQuestion);
        timer = findViewById(R.id.gameTimer);
        score = findViewById(R.id.gameScore);
        buttonA = findViewById(R.id.gameButtonA);
        buttonB = findViewById(R.id.gameButtonB);
        buttonC = findViewById(R.id.gameButtonC);
        buttonD = findViewById(R.id.gameButtonD);

        score.setText("" + db.getScore(player.getPlayer_id()));

        disableButton();

        countDownTimer = new CountDownTimer(22000, 1000) {
            public void onTick(long millisUntilFinished) {

                //here you can have your logic to set text to timeText
                timer.setText(String.valueOf(timeValue) + "\"");

                //With each iteration decrement the time by 1 sec
                timeValue -= 1;

                //This means the user is out of time so onFinished will called after this iteration
                if (timeValue == -1) {

                    //Since user is out of time setText as time up
                    timer.setText("--");

                    //Since user is out of time he won't be able to click any buttons
                    //therefore we will disable all four options buttons using this method
                    disableButton();
                }
            }

            @Override
            public void onFinish() {
                timeUp();
            }

        }.start();

        // VOLLEY REQUEST TO API https://opentdb.com/api.php?amount=5&category=15&type=multiple
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://opentdb.com/api.php?amount=5&category=15&type=multiple";

        // Request a string response from the provided URL.
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            trivias = response.getJSONArray("results");
                            updateQueAndOptions();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(GameActivity.this, "Todo Ok", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GameActivity.this, "connection lost! " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(jsonRequest);

    }

    public void updateQueAndOptions() throws JSONException {
        JSONObject trivia = trivias.getJSONObject(gameNumber);
        JSONArray incorrect = trivia.getJSONArray("incorrect_answers");

        question.setText(Html.escapeHtml(trivia.getString("question")));
        answer = Html.escapeHtml(trivia.getString("correct_answer"));

        ArrayList<String> ans = new ArrayList<String>();
        ans.add(Html.escapeHtml(trivia.getString("correct_answer")));
        ans.add(Html.escapeHtml(incorrect.getString(0)));
        ans.add(Html.escapeHtml(incorrect.getString(1)));
        ans.add(Html.escapeHtml(incorrect.getString(2)));
        Collections.shuffle(ans);

        buttonA.setText(ans.get(0));
        buttonB.setText(ans.get(1));
        buttonC.setText(ans.get(2));
        buttonD.setText(ans.get(3));

        Log.i("game","" + gameNumber);
        Log.i("win", "" + correctAns);

        enableButton();
    };

    public void gameEnd() {
        onStop();
        long totalPoint = correctAns * timeValue;
        gameDao = Room.databaseBuilder(this, AppDatabase.class, "trivia.db").allowMainThreadQueries().build().gameDao();
        Game game = new Game(player.getPlayer_id(),totalPoint);
        gameDao.insert(game);
        Intent intent = new Intent(GameActivity.this, EndGameActivity.class);
        intent.putExtra("Player", player);
        intent.putExtra("Game", game);
        startActivity(intent);
        finish();
    }

    public void buttonA(View view) {
        disableButton();
        if (buttonA.getText().equals(answer)) {
            correctAns += 1;
            timeValue += 10;
            if (gameNumber < 4) {
                dialog("correct");
            } else {gameEnd();}
        } else {
            if (gameNumber < 4) {
                dialog("incorrect");
            } else {gameEnd();}
        }
    }

    public void buttonB(View view) {
        disableButton();
        if (buttonB.getText().equals(answer)) {
            correctAns += 1;
            timeValue += 10;
            if (gameNumber < 4) {
                dialog("correct");
            } else {gameEnd();}
        } else {
            if (gameNumber < 4) {
                dialog("incorrect");
            } else {gameEnd();}
        }
    }

    public void buttonC(View view) {
        disableButton();
        if (buttonC.getText().equals(answer)) {
            correctAns += 1;
            timeValue += 10;
            if (gameNumber < 4) {
                disableButton();
                dialog("correct");
            } else {gameEnd();}
        } else {
            if (gameNumber < 4) {
                dialog("incorrect");
            } else {gameEnd();}
        }
    }

    public void buttonD(View view) {
        disableButton();
        if (buttonD.getText().equals(answer)) {
            correctAns += 1;
            timeValue += 10;
            if (gameNumber < 4) {
                dialog("correct");
            } else {gameEnd();}
        } else {
            if (gameNumber < 4) {
                dialog("incorrect");
            } else {gameEnd();}
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    public void timeUp() {
        Intent intent = new Intent(GameActivity.this, EndGameActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void dialog(String type) {
        final Dialog dialogCorrect = new Dialog(GameActivity.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.activity_game_dialog);
        final TextView text = dialogCorrect.findViewById(R.id.dialogText);

        if (type.equals("correct")){
            text.setText("Correct! :D");
        } else{
            text.setText("Wrong! :(");
        }

        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        onPause();

        Button buttonNext = dialogCorrect.findViewById(R.id.dialogNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCorrect.dismiss();
                gameNumber += 1;
                try {
                    updateQueAndOptions();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                enableButton();
                onRestart();
            }
        });
    }

    //This method will disable all the option button
    public void disableButton() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }

    //This method will all enable the option buttons
    public void enableButton() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
    }

}
