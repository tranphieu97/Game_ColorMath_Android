package com.itute.tranphieu.colormath;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    TextView txtTime, txtScore, txtCellLeft, txtCellRight;
    ImageView imgTrue, imgFalse;
    Button btnYes, btnNo;
    CountDownTimer timer,timer_ShowResult;
    Cell cellLeft, cellRight;
    int countCheck=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        AnhXa();
        setNewGame();
        setButtonClick();
    }

    private void setButtonClick() {
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckGame())
                {
                    UpScore();
                    ChangeCell();
                    setCelltoView();
                    imgTrue.setVisibility(View.VISIBLE);
                    offImgResult(imgTrue);
                }
                else
                {
                    ChangeCell();
                    setCelltoView();
                    imgFalse.setVisibility(View.VISIBLE);
                    offImgResult(imgFalse);
                }
                countCheck++;
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!CheckGame())
                {
                    UpScore();
                    ChangeCell();
                    setCelltoView();
                    imgTrue.setVisibility(View.VISIBLE);
                    offImgResult(imgTrue);
                }
                else
                {
                    ChangeCell();
                    setCelltoView();
                    imgFalse.setVisibility(View.VISIBLE);
                    offImgResult(imgFalse);
                }
                countCheck++;
            }
        });
    }
    private void setNewGame() {
        timer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTime.setText(millisUntilFinished/1000+" s");

            }

            @Override
            public void onFinish() {
                txtTime.setText("0");
                Toast.makeText(PlayActivity.this, "Time out", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("SCORE",txtScore.getText().toString());
                bundle.putInt("COUNTCHECK",  countCheck);
                Intent intent = new Intent(PlayActivity.this,ResultActivity.class);
                intent.putExtra("BUNDLE",bundle);
                startActivity(intent);
            }
        }.start();
        txtScore.setText("0");
        imgTrue.setVisibility(View.INVISIBLE);
        imgFalse.setVisibility(View.INVISIBLE);

        cellLeft =new Cell();
        cellRight = new Cell();
        ChangeCell();
        setCelltoView();
    }
    private void ChangeCell()
    {
        cellLeft.ChangeCell();
        cellRight.ChangeCell();
    }
    private void setCelltoView()
    {
        cellLeft.setView(txtCellLeft);
        cellRight.setView(txtCellRight);
    }
    private void UpScore()
    {
        int score = Integer.parseInt(txtScore.getText().toString());
        score+=10;
        txtScore.setText(String.valueOf(score));
    }
    private boolean CheckGame()
    {
        String colorLeft = cellLeft.getColorMean().getColorName();
        String colorRight = cellRight.getColorSring().getColorName();
        if(colorLeft.equals(colorRight))
        {
            return true;
        }
        else return false;
    }
    private void offImgResult(final ImageView view)
    {
        timer_ShowResult = new CountDownTimer(450,450) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                view.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    private void AnhXa() {
        txtTime = (TextView) findViewById(R.id.TextViewTime);
        txtScore = (TextView) findViewById(R.id.TextViewScore);
        txtCellLeft = (TextView) findViewById(R.id.TextViewCellLeft);
        txtCellRight = (TextView) findViewById(R.id.TextViewCellRight);
        imgTrue = (ImageView) findViewById(R.id.ImageViewTrue);
        imgFalse = (ImageView) findViewById(R.id.ImageViewFalse);
        btnYes = (Button) findViewById(R.id.ButtonYes);
        btnNo = (Button) findViewById(R.id.ButtonNo);
    }
}
